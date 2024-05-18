package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.post.PostDto;
import com.dtu.socialnetwork.mapper.PostMapper;
import com.dtu.socialnetwork.models.Post;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.PostRepository;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostMapper postMapper;


    @Override
    public PostDto createNewPost(PostDto postDto, Integer userId) throws Exception {
        Post post = postMapper.toEntity(postDto);

        Optional<User> user = userRepository.findById(userId);
        post.setUser(user.get());
        post.setCreatedAt(LocalDateTime.now());

        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public List<PostDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public PostDto findPostById(Integer postId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not exist with id = " + postId);
        }

        return postMapper.toDto(post.get());
    }

    @Override
    public List<PostDto> findPostByUserId(Integer userId) {
        return postRepository.findPostByUserId(userId).stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto savePost(Integer postId, Integer userId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not exist with id = " + postId);
        }

        Post savePost = post.get();
        User user = userRepository.findById(userId).get();

        if (user.getSavePosts().contains(savePost)) {
            user.getSavePosts().remove(savePost);
        } else {
            user.getSavePosts().add(savePost);
        }

        userRepository.save(user);

        return postMapper.toDto(savePost);
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not exist with id = " + postId);
        }

        Post delPost = post.get();

        User user = userRepository.findById(userId).get();

        if (!Objects.equals(delPost.getUser().getId(), user.getId())) {
            throw new Exception("You can't delete another user's post");
        }

        postRepository.deleteById(postId);
        return "Post delete successfully with id = " + postId;
    }

    @Override
    public PostDto likePost(Integer postId, Integer userId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not exist with id = " + postId);
        }

        Post likePost = post.get();
        User user = userRepository.findById(userId).get();

        if (likePost.getLikedByUsers().contains(user)) {
            likePost.getLikedByUsers().remove(user);
        } else {
            likePost.getLikedByUsers().add(user);
        }

        return postMapper.toDto(postRepository.save(likePost));
    }

}

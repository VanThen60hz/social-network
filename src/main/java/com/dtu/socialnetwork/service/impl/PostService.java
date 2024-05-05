package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.CreatePostDto;
import com.dtu.socialnetwork.dto.PostDto;
import com.dtu.socialnetwork.mapper.CreatePostMapper;
import com.dtu.socialnetwork.mapper.PostMapper;
import com.dtu.socialnetwork.models.Post;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.PostRepository;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.IPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PostMapper postMapper;
    private final CreatePostMapper createPostMapper;

    public PostService(PostRepository postRepository, UserRepository userRepository, UserService userService, PostMapper postMapper,
                       CreatePostMapper createPostMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.postMapper = postMapper;
        this.createPostMapper = createPostMapper;
    }


    @Override
    public Post createNewPost(CreatePostDto createPostDto, Integer userId) throws Exception {
        Post post = createPostMapper.toEntity(createPostDto);

        User user = userService.findUserById(userId);
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    @Override
    public List<PostDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not exist with id = " + postId);
        }

        return post.get();
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post savePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if (user.getPosts().contains(post)) {
            user.getPosts().remove(post);
        } else {
            user.getPosts().add(post);
        }

        userRepository.save(user);

        return post;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if (!Objects.equals(post.getUser().getId(), user.getId())) {
            throw new Exception("You can't delete another user's post");
        }

        postRepository.deleteById(postId);
        return "Post delete successfully with id = " + postId;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);
        User user = userService.findUserById(userId);

        if (post.getLikedByUsers().contains(user)) {
            post.getLikedByUsers().remove(user);
        } else {
            post.getLikedByUsers().add(user);
        }

        return postRepository.save(post);
    }

}

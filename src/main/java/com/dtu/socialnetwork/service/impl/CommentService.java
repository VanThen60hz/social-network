package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.comment.CommentDto;
import com.dtu.socialnetwork.mapper.CommentMapper;
import com.dtu.socialnetwork.models.Comment;
import com.dtu.socialnetwork.models.Post;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.CommentRepository;
import com.dtu.socialnetwork.repository.PostRepository;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentDto CreateComment(CommentDto commentDto, Integer postId, Integer userId) throws Exception {
        Comment comment = commentMapper.toEntity(commentDto);
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("User not found");
        }

        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new Exception("Post not found");
        }

        comment.setUser(user.get());
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setPost(post.get());

        Comment savedComment = commentRepository.save(comment);

        post.get().getComments().add(savedComment);

        postRepository.save(post.get());

        return commentMapper.toDto(savedComment);
    }

    @Override
    public CommentDto findCommentById(Integer commentId) throws Exception {
        Optional<Comment> comment = commentRepository.findById(commentId);

        if (comment.isEmpty()) {
            throw new Exception("Comment not found");
        }

        return commentMapper.toDto(comment.get());
    }

    @Override
    public CommentDto likeComment(Integer commentId, Integer userId) throws Exception {

        Comment comment = commentMapper.toEntity(findCommentById(commentId));
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new Exception("User not found");
        }

        if (!comment.getLiked().contains(user.get())) {
            comment.getLiked().add(user.get());
        } else {
            comment.getLiked().remove(user.get());
        }

        return commentMapper.toDto(commentRepository.save(comment));
    }
}

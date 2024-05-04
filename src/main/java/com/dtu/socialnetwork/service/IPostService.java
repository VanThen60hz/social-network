package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.PostDto;
import com.dtu.socialnetwork.models.Post;

import java.util.List;

public interface IPostService {
    Post createNewPost(Post post, Integer userId) throws Exception;

    List<PostDto> findAllPost();

    Post findPostById(Integer postId) throws Exception;

    List<Post> findPostByUserId(Integer userId);

    Post savePost(Integer postId, Integer userId) throws Exception;

    String deletePost(Integer postId, Integer userId) throws Exception;

    Post likePost(Integer postId, Integer userId) throws Exception;
}

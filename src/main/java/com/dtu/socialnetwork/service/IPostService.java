package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.post.PostDto;

import java.util.List;

public interface IPostService {
    PostDto createNewPost(PostDto postDto, Integer userId) throws Exception;

    List<PostDto> findAllPost();

    PostDto findPostById(Integer postId) throws Exception;

    List<PostDto> findPostByUserId(Integer userId);

    PostDto savePost(Integer postId, Integer userId) throws Exception;

    String deletePost(Integer postId, Integer userId) throws Exception;

    PostDto likePost(Integer postId, Integer userId) throws Exception;
}

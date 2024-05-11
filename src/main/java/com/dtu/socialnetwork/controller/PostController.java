package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.post.CreatePostDto;
import com.dtu.socialnetwork.dto.post.PostDto;
import com.dtu.socialnetwork.response.ApiResponse;
import com.dtu.socialnetwork.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("user/{userId}")
    public ResponseEntity<PostDto> createNewPost(@RequestBody CreatePostDto createPostDto, @PathVariable Integer userId) throws Exception {
        PostDto newPost = postService.createNewPost(createPostDto, userId);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @DeleteMapping("{postId}/user/{userId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        String message = postService.deletePost(postId, userId);

        ApiResponse apiResponse = new ApiResponse(message, true);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Integer postId) throws Exception {
        PostDto postDto = postService.findPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<PostDto>> findUserPosts(@PathVariable Integer userId) {
        List<PostDto> postDtos = postService.findPostByUserId(userId);
        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> findAllPosts() {
        List<PostDto> posts = postService.findAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PatchMapping("{postId}/user/{userId}")
    public ResponseEntity<PostDto> savePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        PostDto postDto = postService.savePost(postId, userId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping("like/{postId}/user/{userId}")
    public ResponseEntity<PostDto> likePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        PostDto postDto = postService.likePost(postId, userId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}

package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.CreatePostDto;
import com.dtu.socialnetwork.dto.PostDto;
import com.dtu.socialnetwork.models.Post;
import com.dtu.socialnetwork.response.ApiResponse;
import com.dtu.socialnetwork.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createNewPost(@RequestBody CreatePostDto createPostDto, @PathVariable Integer userId) throws Exception {
        Post newPost = postService.createNewPost(createPostDto, userId);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        String message = postService.deletePost(postId, userId);

        ApiResponse apiResponse = new ApiResponse(message, true);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findPostById(@PathVariable Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUserPosts(@PathVariable Integer userId) {
        List<Post> posts = postService.findPostByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> findAllPosts() {
        List<PostDto> posts = postService.findAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PatchMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<Post> savePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.savePost(postId, userId);
        System.out.println(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PatchMapping("/posts/{postId}/like/user/{userId}")
    public ResponseEntity<Post> likePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.likePost(postId, userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}

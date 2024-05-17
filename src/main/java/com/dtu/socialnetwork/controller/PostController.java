package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.post.CreatePostDto;
import com.dtu.socialnetwork.dto.post.PostDto;
import com.dtu.socialnetwork.response.ApiResponse;
import com.dtu.socialnetwork.service.impl.PostService;
import com.dtu.socialnetwork.service.impl.UserService;
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

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<PostDto> createNewPost(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreatePostDto createPostDto
    ) throws Exception {
        PostDto newPost = postService.createNewPost(createPostDto, userService.findByJwt(jwt).getId());
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<ApiResponse> deletePost(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Integer postId) throws Exception {
        String message = postService.deletePost(postId, userService.findByJwt(jwt).getId());

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

    @PatchMapping("{postId}")
    public ResponseEntity<PostDto> savePost(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Integer postId) throws Exception {
        PostDto postDto = postService.savePost(postId, userService.findByJwt(jwt).getId());
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping("like/{postId}")
    public ResponseEntity<PostDto> likePost(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Integer postId) throws Exception {
        PostDto postDto = postService.likePost(postId, userService.findByJwt(jwt).getId());
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}

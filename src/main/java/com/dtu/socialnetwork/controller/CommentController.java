package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.comment.CommentDto;
import com.dtu.socialnetwork.models.Comment;
import com.dtu.socialnetwork.service.impl.CommentService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    @PostMapping("post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @RequestHeader("Authorization") String jwt,
                                                    @PathVariable("postId") Integer postId) throws Exception {
        Integer userId = userService.findByJwt(jwt).getId();
        return ResponseEntity.ok(commentService.CreateComment(commentDto, postId, userId));
    }

    @PatchMapping("like/{commentId}")
    public ResponseEntity<CommentDto> likeComment(@PathVariable("commentId") Integer commentId,
                                                  @RequestHeader("Authorization") String jwt) throws Exception {
        Integer userId = userService.findByJwt(jwt).getId();
        return ResponseEntity.ok(commentService.likeComment(commentId, userId));
    }
}

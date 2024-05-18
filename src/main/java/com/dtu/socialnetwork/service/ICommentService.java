package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.comment.CommentDto;
import com.dtu.socialnetwork.models.Comment;

public interface ICommentService {
    CommentDto CreateComment(CommentDto commentDto, Integer postId, Integer userId) throws Exception;

    CommentDto findCommentById(Integer commentId) throws Exception;

    CommentDto likeComment(Integer commentId, Integer userId) throws Exception;
}

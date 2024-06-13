package com.dtu.socialnetwork.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Post}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Serializable {
    Integer id;
    String caption;
    String image;
    String video;
    UserDto user;
    LocalDateTime createdAt;
    List<UserDto> likedByUsers;
    List<CommentDto> comments;

    /**
     * DTO for {@link com.dtu.socialnetwork.models.User}
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDto implements Serializable {
        Integer id;
        String firstName;
        String lastName;
        String email;
        String gender;
    }


    /**
     * DTO for {@link com.dtu.socialnetwork.models.Comment}
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentDto implements Serializable {
        Integer id;
        String content;
        UserDto user;
        List<UserDto> liked;
        LocalDateTime createdAt;

        /**
         * DTO for {@link com.dtu.socialnetwork.models.User}
         */
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class UserDto implements Serializable {
            Integer id;
            String firstName;
            String lastName;
            String email;
            String gender;
        }
    }
}
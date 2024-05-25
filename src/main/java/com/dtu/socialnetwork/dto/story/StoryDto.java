package com.dtu.socialnetwork.dto.story;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Story}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryDto implements Serializable {
    Integer id;
    UserDto user;
    String image;
    String caption;
    LocalDateTime timestamp;

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
        List<Integer> followers;
        List<Integer> followings;
    }
}
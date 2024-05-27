package com.dtu.socialnetwork.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Message}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto implements Serializable {
    Integer id;
    String content;
    String image;
    LocalDateTime timestamp;
    UserDto user;

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
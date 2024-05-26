package com.dtu.socialnetwork.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Chat}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto implements Serializable {
    Integer id;
    String chatName;
    String chatImage;
    Set<UserDto> chatUser;
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
    }
}
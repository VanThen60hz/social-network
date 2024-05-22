package com.dtu.socialnetwork.dto.reel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Reel}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReelDto implements Serializable {
    Integer id;
    String title;
    UserDto user;
    String video;

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
        String password;
        String gender;
        List<Integer> followers;
        List<Integer> followings;
    }
}
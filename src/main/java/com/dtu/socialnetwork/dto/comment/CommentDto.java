package com.dtu.socialnetwork.dto.comment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Comment}
 */
public class CommentDto implements Serializable {
    private final Integer id;
    private final String content;
    private final Integer userId;
    private final String userFirstName;
    private final String userLastName;
    private final String userEmail;
    private final String userPassword;
    private final String userGender;
    private final List<Integer> userFollowers;
    private final List<Integer> userFollowings;
    private final List<UserDto> liked;
    private final LocalDateTime createdAt;
    private final Integer postId;
    private final String postCaption;
    private final String postImage;
    private final String postVideo;
    private final LocalDateTime postCreatedAt;

    public CommentDto(Integer id, String content, Integer userId, String userFirstName, String userLastName, String userEmail, String userPassword, String userGender, List<Integer> userFollowers, List<Integer> userFollowings, List<UserDto> liked, LocalDateTime createdAt, Integer postId, String postCaption, String postImage, String postVideo, LocalDateTime postCreatedAt) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userFollowers = userFollowers;
        this.userFollowings = userFollowings;
        this.liked = liked;
        this.createdAt = createdAt;
        this.postId = postId;
        this.postCaption = postCaption;
        this.postImage = postImage;
        this.postVideo = postVideo;
        this.postCreatedAt = postCreatedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public List<Integer> getUserFollowers() {
        return userFollowers;
    }

    public List<Integer> getUserFollowings() {
        return userFollowings;
    }

    public List<UserDto> getLiked() {
        return liked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getPostCaption() {
        return postCaption;
    }

    public String getPostImage() {
        return postImage;
    }

    public String getPostVideo() {
        return postVideo;
    }

    public LocalDateTime getPostCreatedAt() {
        return postCreatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto entity = (CommentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.content, entity.content) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.userFirstName, entity.userFirstName) &&
                Objects.equals(this.userLastName, entity.userLastName) &&
                Objects.equals(this.userEmail, entity.userEmail) &&
                Objects.equals(this.userPassword, entity.userPassword) &&
                Objects.equals(this.userGender, entity.userGender) &&
                Objects.equals(this.userFollowers, entity.userFollowers) &&
                Objects.equals(this.userFollowings, entity.userFollowings) &&
                Objects.equals(this.liked, entity.liked) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.postId, entity.postId) &&
                Objects.equals(this.postCaption, entity.postCaption) &&
                Objects.equals(this.postImage, entity.postImage) &&
                Objects.equals(this.postVideo, entity.postVideo) &&
                Objects.equals(this.postCreatedAt, entity.postCreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, userId, userFirstName, userLastName, userEmail, userPassword, userGender, userFollowers, userFollowings, liked, createdAt, postId, postCaption, postImage, postVideo, postCreatedAt);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "content = " + content + ", " +
                "userId = " + userId + ", " +
                "userFirstName = " + userFirstName + ", " +
                "userLastName = " + userLastName + ", " +
                "userEmail = " + userEmail + ", " +
                "userPassword = " + userPassword + ", " +
                "userGender = " + userGender + ", " +
                "userFollowers = " + userFollowers + ", " +
                "userFollowings = " + userFollowings + ", " +
                "liked = " + liked + ", " +
                "createdAt = " + createdAt + ", " +
                "postId = " + postId + ", " +
                "postCaption = " + postCaption + ", " +
                "postImage = " + postImage + ", " +
                "postVideo = " + postVideo + ", " +
                "postCreatedAt = " + postCreatedAt + ")";
    }

    /**
     * DTO for {@link com.dtu.socialnetwork.models.User}
     */
    public static class UserDto implements Serializable {
        private final Integer id;
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String password;
        private final String gender;
        private final List<Integer> followers;
        private final List<Integer> followings;

        public UserDto(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> followers, List<Integer> followings) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.gender = gender;
            this.followers = followers;
            this.followings = followings;
        }

        public Integer getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getGender() {
            return gender;
        }

        public List<Integer> getFollowers() {
            return followers;
        }

        public List<Integer> getFollowings() {
            return followings;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserDto entity = (UserDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.firstName, entity.firstName) &&
                    Objects.equals(this.lastName, entity.lastName) &&
                    Objects.equals(this.email, entity.email) &&
                    Objects.equals(this.password, entity.password) &&
                    Objects.equals(this.gender, entity.gender) &&
                    Objects.equals(this.followers, entity.followers) &&
                    Objects.equals(this.followings, entity.followings);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName, email, password, gender, followers, followings);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "firstName = " + firstName + ", " +
                    "lastName = " + lastName + ", " +
                    "email = " + email + ", " +
                    "password = " + password + ", " +
                    "gender = " + gender + ", " +
                    "followers = " + followers + ", " +
                    "followings = " + followings + ")";
        }
    }
}
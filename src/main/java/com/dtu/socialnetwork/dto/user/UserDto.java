package com.dtu.socialnetwork.dto.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.dtu.socialnetwork.models.User}
 */
public class UserDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String gender;
    private final List<Integer> followers;
    private final List<Integer> followings;
    private final Set<PostDto> savePosts;

    public UserDto(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> followers, List<Integer> followings, Set<PostDto> savePosts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.followers = followers;
        this.followings = followings;
        this.savePosts = savePosts;
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

    public Set<PostDto> getSavePosts() {
        return savePosts;
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
                Objects.equals(this.followings, entity.followings) &&
                Objects.equals(this.savePosts, entity.savePosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, gender, followers, followings, savePosts);
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
                "followings = " + followings + ", " +
                "savePosts = " + savePosts + ")";
    }

    /**
     * DTO for {@link com.dtu.socialnetwork.models.Post}
     */
    public static class PostDto implements Serializable {
        private final Integer id;
        private final String caption;
        private final String image;
        private final String video;
        private final LocalDateTime createdAt;

        public PostDto(Integer id, String caption, String image, String video, LocalDateTime createdAt) {
            this.id = id;
            this.caption = caption;
            this.image = image;
            this.video = video;
            this.createdAt = createdAt;
        }

        public Integer getId() {
            return id;
        }

        public String getCaption() {
            return caption;
        }

        public String getImage() {
            return image;
        }

        public String getVideo() {
            return video;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PostDto entity = (PostDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.caption, entity.caption) &&
                    Objects.equals(this.image, entity.image) &&
                    Objects.equals(this.video, entity.video) &&
                    Objects.equals(this.createdAt, entity.createdAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, caption, image, video, createdAt);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "caption = " + caption + ", " +
                    "image = " + image + ", " +
                    "video = " + video + ", " +
                    "createdAt = " + createdAt + ")";
        }
    }
}
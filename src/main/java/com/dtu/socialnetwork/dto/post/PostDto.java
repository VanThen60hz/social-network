package com.dtu.socialnetwork.dto.post;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Post}
 */
public class PostDto implements Serializable {
    private final Integer id;
    private final String caption;
    private final String image;
    private final String video;
    private final UserOfPostDto user;
    private final LocalDateTime createdAt;
    private final List<UserOfPostDto> likedByUsers;

    public PostDto(Integer id, String caption, String image, String video, UserOfPostDto user, LocalDateTime createdAt, List<UserOfPostDto> likedByUsers) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.user = user;
        this.createdAt = createdAt;
        this.likedByUsers = likedByUsers;
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

    public UserOfPostDto getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<UserOfPostDto> getLikedByUsers() {
        return likedByUsers;
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
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.likedByUsers, entity.likedByUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caption, image, video, user, createdAt, likedByUsers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "caption = " + caption + ", " +
                "image = " + image + ", " +
                "video = " + video + ", " +
                "user = " + user + ", " +
                "createdAt = " + createdAt + ", " +
                "likedByUsers = " + likedByUsers + ")";
    }
}
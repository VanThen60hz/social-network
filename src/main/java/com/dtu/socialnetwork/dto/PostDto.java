package com.dtu.socialnetwork.dto;

import lombok.Data;
import lombok.Setter;

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
    private final Integer userId;
    private final LocalDateTime createdAt;
    private final List<Integer> likedByUserIds;

    public PostDto(Integer id, String caption, String image, String video, Integer userId, LocalDateTime createdAt, List<Integer> likedByUserIds) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.userId = userId;
        this.createdAt = createdAt;
        this.likedByUserIds = likedByUserIds;
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

    public Integer getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Integer> getLikedByUserIds() {
        return likedByUserIds;
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
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.likedByUserIds, entity.likedByUserIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, caption, image, video, userId, createdAt, likedByUserIds);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "caption = " + caption + ", " +
                "image = " + image + ", " +
                "video = " + video + ", " +
                "userId = " + userId + ", " +
                "createdAt = " + createdAt + ", " +
                "likedByUserIds = " + likedByUserIds + ")";
    }
}
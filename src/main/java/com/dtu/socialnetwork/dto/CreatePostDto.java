package com.dtu.socialnetwork.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.dtu.socialnetwork.models.Post}
 */
public class CreatePostDto implements Serializable {
    private final String caption;
    private final String image;
    private final String video;

    public CreatePostDto(String caption, String image, String video) {
        this.caption = caption;
        this.image = image;
        this.video = video;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePostDto entity = (CreatePostDto) o;
        return Objects.equals(this.caption, entity.caption) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.video, entity.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, image, video);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "caption = " + caption + ", " +
                "image = " + image + ", " +
                "video = " + video + ")";
    }
}
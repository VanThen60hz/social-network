package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.post.PostDto;
import com.dtu.socialnetwork.models.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    Post toEntity(PostDto postDto);

    @AfterMapping
    default void linkComments(@MappingTarget Post post) {
        post.getComments().forEach(comment -> comment.setPost(post));
    }

    PostDto toDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(PostDto postDto, @MappingTarget Post post);
}
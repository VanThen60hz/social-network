package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.CreatePostDto;
import com.dtu.socialnetwork.models.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CreatePostMapper {
    Post toEntity(CreatePostDto createPostDto);

    CreatePostDto toDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(CreatePostDto createPostDto, @MappingTarget Post post);
}
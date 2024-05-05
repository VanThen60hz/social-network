package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.PostDto;
import com.dtu.socialnetwork.models.Post;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostDto postDto);

    PostDto toDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(PostDto postDto, @MappingTarget Post post);
}
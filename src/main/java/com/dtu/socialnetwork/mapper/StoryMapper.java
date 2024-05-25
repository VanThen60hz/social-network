package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.story.StoryDto;
import com.dtu.socialnetwork.models.Story;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StoryMapper {
    Story toEntity(StoryDto storyDto);

    StoryDto toDto(Story story);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Story partialUpdate(StoryDto storyDto, @MappingTarget Story story);
}
package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.message.MessageDto;
import com.dtu.socialnetwork.models.Message;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {
    Message toEntity(MessageDto messageDto);

    MessageDto toDto(Message message);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Message partialUpdate(MessageDto messageDto, @MappingTarget Message message);
}
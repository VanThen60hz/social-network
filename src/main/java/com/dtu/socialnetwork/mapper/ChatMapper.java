package com.dtu.socialnetwork.mapper;

import com.dtu.socialnetwork.dto.chat.ChatDto;
import com.dtu.socialnetwork.models.Chat;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChatMapper {
    Chat toEntity(ChatDto chatDto);

    @AfterMapping
    default void linkMessages(@MappingTarget Chat chat) {
        if (chat.getMessages() != null) {
            chat.getMessages().forEach(message -> message.setChat(chat));
        }
    }

    ChatDto toDto(Chat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chat partialUpdate(ChatDto chatDto, @MappingTarget Chat chat);
}
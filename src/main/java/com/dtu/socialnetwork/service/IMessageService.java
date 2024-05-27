package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.message.MessageDto;
import com.dtu.socialnetwork.models.Chat;
import com.dtu.socialnetwork.models.Message;
import com.dtu.socialnetwork.models.User;

import java.util.List;

public interface IMessageService {

    MessageDto createMessage(User user, Integer chatId, MessageDto messageDto) throws Exception;

    List<MessageDto> findChatMessages(Integer chatId) throws Exception;
}

package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.message.MessageDto;
import com.dtu.socialnetwork.mapper.MessageMapper;
import com.dtu.socialnetwork.models.Chat;
import com.dtu.socialnetwork.models.Message;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.ChatRepository;
import com.dtu.socialnetwork.repository.MessageRepository;
import com.dtu.socialnetwork.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ChatRepository chatRepository;


    @Override
    public MessageDto createMessage(User user, Integer chatId, MessageDto req) throws Exception {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new Exception("Chat not found"));

        Message message = messageMapper.toEntity(req);
        message.setChat(chat);
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());

        Message savedMessage = messageRepository.save(message);
        chat.getMessages().add(savedMessage);
        chatRepository.save(chat);

        return messageMapper.toDto(savedMessage);
    }

    @Override
    public List<MessageDto> findChatMessages(Integer chatId) throws Exception {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new Exception("Chat not found"));

        return messageRepository.findByChatId(chat.getId()).stream().map(messageMapper::toDto).toList();
    }
}

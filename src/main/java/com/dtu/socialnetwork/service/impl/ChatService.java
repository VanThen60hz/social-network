package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.chat.ChatDto;
import com.dtu.socialnetwork.mapper.ChatMapper;
import com.dtu.socialnetwork.models.Chat;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.ChatRepository;
import com.dtu.socialnetwork.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService implements IChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatMapper chatMapper;


    @Override
    public ChatDto createOneToOneChat(User reqUser, User user2) {
        Chat isChatExist = chatRepository.findChatByUsersId(user2, reqUser);

        if (isChatExist != null) {
            return chatMapper.toDto(isChatExist);
        }
        Chat chat = new Chat();
        chat.setChatName("OneToOne" + reqUser.getFirstName() + " " + reqUser.getLastName() + "&" + user2.getFirstName() + " " + user2.getLastName());
        chat.getChatUser().add(user2);
        chat.getChatUser().add(reqUser);
        chat.setTimestamp(LocalDateTime.now());
        return chatMapper.toDto(chatRepository.save(chat));
    }

    @Override
    public ChatDto findChatById(Integer chatId) {
        Optional<Chat> opt = chatRepository.findById(chatId);
        if (opt.isEmpty()) {
            throw new RuntimeException("Chat not found with id: " + chatId);
        }
        return chatMapper.toDto(opt.get());
    }

    @Override
    public List<ChatDto> findUsersChat(Integer userId) {
        return chatRepository.findChatByUserId(userId).stream().map(chatMapper::toDto).toList();
    }
}

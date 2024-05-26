package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.chat.ChatDto;
import com.dtu.socialnetwork.models.User;

import java.util.List;

public interface IChatService {
    public ChatDto createChat(User reqUser, User user2);

    public ChatDto findChatById(Integer chatId);

    public List<ChatDto> findUsersChat(Integer userId);
}

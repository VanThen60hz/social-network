package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RealTimeChat {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{chatId}")
    public void sendMessageToChat(@Payload Message message,
                                  @DestinationVariable String chatId) {
        simpMessagingTemplate.convertAndSend("/group/chat/" + chatId, message);
    }
}

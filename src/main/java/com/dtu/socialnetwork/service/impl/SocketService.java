package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.service.ISocketService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SocketService implements ISocketService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public SocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void sendMessage(String topic, Object payload) {
        simpMessagingTemplate.convertAndSend(topic, payload);
    }
}
package com.dtu.socialnetwork.service;

public interface ISocketService {

    void sendMessage(String topic, Object payload);
}

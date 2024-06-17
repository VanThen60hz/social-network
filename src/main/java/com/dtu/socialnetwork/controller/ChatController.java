package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.chat.ChatDto;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.request.CreateChatRequest;
import com.dtu.socialnetwork.service.IChatService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private IChatService chatService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<ChatDto> creatOneToOneChat(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateChatRequest req) throws Exception {
        User reqUser = userService.findByJwt(jwt);
        User user2 = userRepository.findById(req.getUserId()).orElseThrow(() -> new Exception("User not found"));
        return ResponseEntity.ok(chatService.createOneToOneChat(reqUser, user2));
    }

    @GetMapping()
    public ResponseEntity<List<ChatDto>> findUsersChat(@RequestHeader("Authorization") String jwt) {
        User user = userService.findByJwt(jwt);
        return ResponseEntity.ok(chatService.findUsersChat(user.getId()));
    }
}

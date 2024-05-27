package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.message.MessageDto;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.service.IMessageService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping("/chat/{chatId}")
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto req,
                                                    @RequestHeader("Authorization") String jwt,
                                                    @PathVariable Integer chatId) throws Exception {
        User user = userService.findByJwt(jwt);
        return ResponseEntity.ok(messageService.createMessage(user, chatId, req));
    }

    @GetMapping("/chat/{chatId}")
    public ResponseEntity<List<MessageDto>> findChatMessages(@RequestHeader("Authorization") String jwt,
                                                             @PathVariable Integer chatId) throws Exception {
        userService.findByJwt(jwt);
        return ResponseEntity.ok(messageService.findChatMessages(chatId));
    }
}

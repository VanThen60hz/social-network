package com.dtu.socialnetwork.controller;


import com.dtu.socialnetwork.dto.story.StoryDto;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.service.IStoryService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    @Autowired
    private IStoryService storyService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<StoryDto> createStory(@RequestBody StoryDto storyDto,
                                                @RequestHeader("Authorization") String jwt) {
        User reqUser = userService.findByJwt(jwt);
        StoryDto newStory = storyService.createStory(storyDto, reqUser);

        return ResponseEntity.ok(newStory);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<StoryDto>> findUserStory(@PathVariable Integer userId, @RequestHeader("Authorization") String jwt) throws Exception {
        return ResponseEntity.ok(storyService.findStoryByUserId(userId));
    }
}

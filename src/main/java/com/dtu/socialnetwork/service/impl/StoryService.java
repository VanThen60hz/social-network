package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.story.StoryDto;
import com.dtu.socialnetwork.mapper.StoryMapper;
import com.dtu.socialnetwork.models.Story;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.StoryRepository;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryService implements IStoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StoryMapper storyMapper;


    @Override
    public StoryDto createStory(StoryDto storyDto, User user) {
        Story story = storyMapper.toEntity(storyDto);
        
        story.setUser(user);
        story.setTimestamp(LocalDateTime.now());
        storyRepository.save(story);

        return storyMapper.toDto(story);
    }

    @Override
    public List<StoryDto> findStoryByUserId(Integer userId) throws Exception {

        userService.findUserById(userId);
        return storyRepository.findByUserId(userId).stream().map(storyMapper::toDto).toList();
    }
}

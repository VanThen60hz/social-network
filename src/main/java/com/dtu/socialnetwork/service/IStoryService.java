package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.story.StoryDto;
import com.dtu.socialnetwork.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStoryService {

    public StoryDto createStory(StoryDto storyDto, User user);

    public List<StoryDto> findStoryByUserId(Integer userId) throws Exception;
}

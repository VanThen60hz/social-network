package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.reel.ReelDto;
import com.dtu.socialnetwork.models.User;

import java.util.List;

public interface IReelService {
    public ReelDto createReel(ReelDto reelDto, User user);

    public List<ReelDto> getAllReels();

    public List<ReelDto> findUserReel(Integer userId) throws Exception;
}

package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.dto.reel.ReelDto;
import com.dtu.socialnetwork.mapper.ReelMapper;
import com.dtu.socialnetwork.models.Reel;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.ReelRepository;
import com.dtu.socialnetwork.service.IReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelService implements IReelService {
    @Autowired
    private ReelRepository reelRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ReelMapper reelMapper;

    @Override
    public ReelDto createReel(ReelDto reelDto, User user) {
        Reel newReel = new Reel();
        newReel.setTitle(reelDto.getTitle());
        newReel.setUser(user);
        newReel.setVideo(reelDto.getVideo());


        return reelMapper.toDto(reelRepository.save(newReel));
    }

    @Override
    public List<ReelDto> getAllReels() {
        return reelRepository.findAll().stream().map(reelMapper::toDto).toList();
    }

    @Override
    public List<ReelDto> findUserReel(Integer userId) throws Exception {
        userService.findUserById(userId);
        return reelRepository.findAllByUserId(userId).stream().map(reelMapper::toDto).toList();
    }
}

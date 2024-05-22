package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.reel.ReelDto;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.service.IReelService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reels")
public class ReelController {

    @Autowired
    private IReelService reelService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<ReelDto> createReel(@RequestBody ReelDto reelDto,
                                              @RequestHeader("Authorization") String jwt) {
        User reqUser = userService.findByJwt(jwt);
        ReelDto newReel = reelService.createReel(reelDto, reqUser);

        return ResponseEntity.ok(newReel);
    }

    @GetMapping()
    public ResponseEntity<List<ReelDto>> getAllReels() {
        return ResponseEntity.ok(reelService.getAllReels());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<ReelDto>> findUserReel(@PathVariable Integer userId) throws Exception {
        return ResponseEntity.ok(reelService.findUserReel(userId));
    }

}

package com.dtu.socialnetwork.repository;

import com.dtu.socialnetwork.models.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReelRepository extends JpaRepository<Reel, Integer> {

    public List<Reel> findAllByUserId(Integer userId);
}

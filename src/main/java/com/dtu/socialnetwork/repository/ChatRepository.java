package com.dtu.socialnetwork.repository;

import com.dtu.socialnetwork.models.Chat;
import com.dtu.socialnetwork.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @Query("SELECT c FROM Chat c JOIN c.chatUser u WHERE u.id = :userId")
    List<Chat> findChatByUserId(@Param("userId") Integer userId);

    @Query("SELECT c FROM Chat c WHERE :user MEMBER OF c.chatUser AND :reqUser MEMBER OF c.chatUser")
    public Chat findChatByUsersId(@Param("user") User user, @Param("reqUser") User reqUser);
}

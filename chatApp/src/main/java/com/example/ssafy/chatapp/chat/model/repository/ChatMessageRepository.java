package com.example.ssafy.chatapp.chat.model.repository;

import com.example.ssafy.chatapp.chat.model.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // 처음에는 전부 가지고 오는 것으로 설정하고
    // 추후에는 메시지 가져오는 최적화를 위한 로직 수정
    List<ChatMessage> findChatMessageByRoomId(Long roomId);
}

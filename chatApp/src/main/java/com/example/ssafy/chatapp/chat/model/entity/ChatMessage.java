package com.example.ssafy.chatapp.chat.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="chat_messages")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) // 생성 시간 자동 기록
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private Long roomId;
    private Long senderId;
    private String nickname;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public ChatMessage(Long roomId, Long senderId, String nickname, String content, MessageType messageType) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.nickname = nickname;
        this.content = content;
        this.messageType = messageType;
    }

    public enum MessageType { TALK, ENTER, QUIT, IMAGE }
}

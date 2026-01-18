package com.example.ssafy.chatapp.chat.model.dto;

import com.example.ssafy.chatapp.chat.model.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    public enum MessageType {
        ENTER, TALK, QUIT, IMAGE
    }

    private MessageType type;      // 메시지 타입 (입장, 퇴장, 채팅, 이미지)
    private Long roomId;           // 방 번호
    private Long senderId;         // 보낸 사람 ID
    private String nickname;       // 보낸 사람 닉네임
    private String content;        // 메시지 내용 (텍스트 혹은 S3 URL)
    private LocalDateTime createdAt; // 전송 시간

    // Entity -> DTO 변환 메서드 (조회 시 사용)
    public static ChatMessageDto fromEntity(ChatMessage entity) {
        return ChatMessageDto.builder()
                .type(MessageType.valueOf(entity.getMessageType().name()))
                .roomId(entity.getRoomId())
                .senderId(entity.getSenderId())
                .nickname(entity.getNickname())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

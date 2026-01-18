package com.example.ssafy.chatapp.chat.service;

import com.example.ssafy.chatapp.chat.model.dto.ChatMessageDto;
import com.example.ssafy.chatapp.chat.model.entity.ChatMessage;
import com.example.ssafy.chatapp.chat.model.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private ChatMessageRepository chatMessageRepository;

    @Override
    @Transactional
    public ChatMessageDto saveMessage(ChatMessageDto messageDto) {
        // 1. DTO를 Entity로 변환
        ChatMessage chatMessage = ChatMessage.builder()
                .roomId(messageDto.getRoomId())
                .senderId(messageDto.getSenderId())
                .nickname(messageDto.getNickname())
                .content(messageDto.getContent())
                .messageType(ChatMessage.MessageType.valueOf(messageDto.getType().name()))
                .build();

        // 2. DB 저장
//        chatMessageRepository.save(chatMessage);

        // 3. 다시 DTO로 변환하거나 필요한 데이터 세팅 후 반환
        return messageDto;
    }
}

package com.example.ssafy.chatapp.chat.controller;


import com.example.ssafy.chatapp.chat.model.dto.ChatMessageDto;
import com.example.ssafy.chatapp.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatService chatService;

    @MessageMapping("/chat/send")
    public void sendMessage(ChatMessageDto message) {

        // 1. 서비스 레이어를 통해 메시지 저장 및 비즈니스 로직 처리
        ChatMessageDto savedMessage = chatService.saveMessage(message);

        // 2. 저장된 메시지를 해당 방 구독자들에게 전달
        messagingTemplate.convertAndSend("/topic/room/" + savedMessage.getRoomId(), savedMessage);
    }
}

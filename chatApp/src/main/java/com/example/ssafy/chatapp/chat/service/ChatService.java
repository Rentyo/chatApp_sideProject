package com.example.ssafy.chatapp.chat.service;

import com.example.ssafy.chatapp.chat.model.dto.ChatMessageDto;

public interface ChatService {
    public ChatMessageDto saveMessage(ChatMessageDto messageDto);
}

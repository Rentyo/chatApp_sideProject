package com.example.ssafy.chatapp.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // WebSocket 메시지 브로커 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트가 WebSocket에 접속할 엔드포인트 설정
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("*") // 테스트를 위해 모든 도메인 허용
                .withSockJS(); // 브라우저 호환성을 위해 SockJS 사용
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메시지를 구독(수신)하는 요청의 접두사
        registry.enableSimpleBroker("/topic");

        // 메시지를 발행(전송)하는 요청의 접두사
        registry.setApplicationDestinationPrefixes("/app");
    }
}

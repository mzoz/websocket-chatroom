package edu.udacity.java.nano.chatroom;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/broadcast")
    public ChatMessage broadcastMessage(@Payload ChatMessage chatMessage, StompHeaderAccessor accessor) {
        // System.out.println(chatMessage.getName() + ": " + accessor.getCommand());
        return chatMessage;
    }

    @SubscribeMapping("/count")
    public String foo() {
        // System.out.println("count number sent!");
        return String.valueOf(WebSocketConfig.getCount());
    }

}

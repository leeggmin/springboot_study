package jimin.study.chatting.stomp.controller;

import jimin.study.chatting.stomp.ro.StompMessage;
import jimin.study.chatting.stomp.service.StompService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final StompService stompService;

    @MessageMapping("/send")
    public void publish(StompMessage message) {
        System.out.println(message.getRoomId());
        System.out.println(message.getMessage());
        simpMessagingTemplate.convertAndSend("/sub/room/" + message.getRoomId(), message);
        stompService.sendMessage(message);
    }
}

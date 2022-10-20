package jimin.study.chatting.domain.stomp.controller;

import jimin.study.chatting.domain.chat.service.MessageService;
import jimin.study.chatting.domain.stomp.ro.StompMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @MessageMapping("/send")
    public void publish(StompMessage message) {
        System.out.println(message.getRoomId());
        System.out.println(message.getMessage());
        simpMessagingTemplate.convertAndSend("/sub/room/" + message.getRoomId(), message);
        messageService.sendMessage(message);
    }
}

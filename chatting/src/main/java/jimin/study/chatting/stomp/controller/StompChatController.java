package jimin.study.chatting.stomp.controller;

import jimin.study.chatting.stomp.ro.StompMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessageSendingOperations messageSendingOperations;

    @MessageMapping("/umm")
    public void publish(StompMessage message) {
        messageSendingOperations.convertAndSend("/sub/channel/" + message.getChannelId(), message);
    }
}

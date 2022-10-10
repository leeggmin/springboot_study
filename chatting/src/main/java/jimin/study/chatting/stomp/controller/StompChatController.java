package jimin.study.chatting.stomp.controller;

import jimin.study.chatting.stomp.dto.RoomCreateDto;
import jimin.study.chatting.stomp.ro.StompMessage;
import jimin.study.chatting.stomp.service.StompService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessageSendingOperations messageSendingOperations;
    private final StompService stompService;

    @PostMapping
    public RoomCreateDto createRoom(@RequestParam String name) {
        return stompService.createRoom(name);
    }

    @MessageMapping("/send")
    public void publish(StompMessage message) {
        messageSendingOperations.convertAndSend("/sub/channel/" + message.getChannelId(), message);
        stompService.sendMessage(message);
    }
}

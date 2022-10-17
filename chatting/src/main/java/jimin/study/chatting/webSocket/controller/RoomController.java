package jimin.study.chatting.webSocket.controller;

import jimin.study.chatting.stomp.dto.RoomCreateDto;
import jimin.study.chatting.stomp.service.StompService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final StompService stompService;

    @PostMapping("/{roomName}")
    public RoomCreateDto createRoom(@PathVariable("roomName") String name) {
        return stompService.createRoom(name);
    }
}

package jimin.study.chatting.domain.chat.controller;

import jimin.study.chatting.domain.chat.dto.MessageDto;
import jimin.study.chatting.domain.chat.dto.RoomCreateDto;
import jimin.study.chatting.domain.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/create/{roomName}")
    public RoomCreateDto createRoom(@PathVariable("roomName") String name) {
        return roomService.createRoom(name);
    }

//    @GetMapping("/read-message/{roomId}")
//    public List<MessageDto> readMessageOfRoom(@PathVariable("roomId")Long roomId) {
//
//    }
}

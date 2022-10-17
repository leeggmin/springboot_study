package jimin.study.chatting.stomp.service;

import jimin.study.chatting.exception.ChatException;
import jimin.study.chatting.stomp.domain.entity.Message;
import jimin.study.chatting.stomp.domain.entity.Room;
import jimin.study.chatting.stomp.domain.repository.MessageRepository;
import jimin.study.chatting.stomp.domain.repository.RoomRepository;
import jimin.study.chatting.stomp.dto.RoomCreateDto;
import jimin.study.chatting.stomp.ro.StompMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StompService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public RoomCreateDto createRoom(String name) {
        Room room = Room.builder().name(name).build();
        roomRepository.save(room);
        return new RoomCreateDto(room.getId().toString());
    }

    @Transactional
    public void sendMessage(StompMessage message) {
        Optional.ofNullable(roomRepository.findById(Long.parseLong(message.getRoomId()))).ifPresentOrElse(
                room -> { messageRepository.save(Message.builder()
                                    .room(room.get())
                                    .text(message.getMessage()).build());
                }, () -> {throw new ChatException("Room not found");});
    }
}

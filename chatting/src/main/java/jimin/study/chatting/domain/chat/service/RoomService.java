package jimin.study.chatting.domain.chat.service;

import jimin.study.chatting.domain.chat.domain.entity.Room;
import jimin.study.chatting.domain.chat.domain.repository.RoomRepository;
import jimin.study.chatting.domain.chat.dto.RoomCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public RoomCreateDto createRoom(String name) {
        Room room = Room.builder().name(name).build();
        roomRepository.save(room);
        return new RoomCreateDto(room.getId().toString());
    }
}

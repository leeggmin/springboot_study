package jimin.study.chatting.domain.chat.service;

import jimin.study.chatting.domain.chat.domain.entity.Message;
import jimin.study.chatting.domain.chat.domain.repository.MessageRepository;
import jimin.study.chatting.domain.chat.domain.repository.RoomRepository;
import jimin.study.chatting.domain.stomp.ro.StompMessage;
import jimin.study.chatting.global.exception.ChatException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void sendMessage(StompMessage message) {
        Optional.ofNullable(roomRepository.findById(Long.parseLong(message.getRoomId()))).ifPresentOrElse(
                room -> { messageRepository.save(Message.builder()
                        .room(room.get())
                        .content(message.getMessage()).build());
                }, () -> {throw new ChatException("Room not found");});
    }
}

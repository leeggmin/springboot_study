package jimin.study.chatting.chat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jimin.study.chatting.chat.ro.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ObjectMapper objectMapper;
    private HashMap<String, ChatRoom> chatRooms = new HashMap<>();

    public ChatRoom findByChatRoomId(String roomId) {
        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .name(name).build();
        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }
    public void sendMessage(WebSocketSession session, String message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public List<ChatRoom> findAllRoom() {
        return chatRooms.values().stream().toList();
    }
}

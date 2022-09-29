package jimin.study.chatting.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jimin.study.chatting.chat.dto.ChatMessage;
import jimin.study.chatting.chat.dto.ChatRoom;
import jimin.study.chatting.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;
    private static HashMap<String, WebSocketSession> sessionMap = new HashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom chatRoom = chatService.findByChatRoomId(chatMessage.getRoomId());
        chatRoom.handleActions(session, chatMessage, chatService);

//        여기 밑부턴 채팅방 1개 로직
        for (String key : sessionMap.keySet()) {
            WebSocketSession ws = sessionMap.get(key);
            try {
                ws.sendMessage(new TextMessage(payload));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId(), session);
        super.afterConnectionClosed(session, status);
    }
}

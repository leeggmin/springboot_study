package jimin.study.chatting.webSocket.ro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jimin.study.chatting.webSocket.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ChatRoom {

    private String roomId;
    private String name;
    @JsonIgnore
    private Set<WebSocketSession> sessions;

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
        this.sessions = new HashSet<>();
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        if (chatMessage.getMessageType().equals(ChatMessage.MessageType.ENTER)) {
            sessions.add(session);
            System.out.println(sessions);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService);
    }

    protected void sendMessage(ChatMessage chatMessage, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, chatMessage.getMessage()));
    }
}

package jimin.study.chatting.chat.dto;

import lombok.Getter;

@Getter
public class ChatMessage {

    public enum MessageType {
        ENTER, TALK
    }

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;
}

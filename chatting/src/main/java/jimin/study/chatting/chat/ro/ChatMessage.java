package jimin.study.chatting.chat.ro;

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

    protected void setMessage(String message) {
        this.message = message;
    }
}

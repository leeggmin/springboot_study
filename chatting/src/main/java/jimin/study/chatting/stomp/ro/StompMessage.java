package jimin.study.chatting.stomp.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StompMessage {

    private String sender;
    private String channelId;
    private String message;
}

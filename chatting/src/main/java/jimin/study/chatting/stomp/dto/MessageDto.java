package jimin.study.chatting.stomp.dto;

import jimin.study.chatting.stomp.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageDto {

    private User user;
    private String message;
}

package jimin.study.chatting.domain.chat.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MessageDto {

    private String content;
    private String userId;
    private LocalDateTime sendMessageDataTime;
}

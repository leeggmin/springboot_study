package jimin.study.chatting.stomp.domain.repository;

import jimin.study.chatting.stomp.domain.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

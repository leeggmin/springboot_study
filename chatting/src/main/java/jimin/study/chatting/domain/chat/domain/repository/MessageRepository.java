package jimin.study.chatting.domain.chat.domain.repository;

import jimin.study.chatting.domain.chat.domain.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}

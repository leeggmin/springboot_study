package jimin.study.chatting.stomp.domain.repository;

import jimin.study.chatting.stomp.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

package jimin.study.chatting.domain.chat.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jimin.study.chatting.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "camp_to_facility")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserToRoom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;
}

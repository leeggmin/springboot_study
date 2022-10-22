package jimin.study.chatting.domain.user.domain.entity;

import jimin.study.chatting.domain.chat.domain.entity.UserToRoom;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String pw;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<UserToRoom> userToRooms = new ArrayList<>();
}

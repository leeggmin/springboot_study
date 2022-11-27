package jimin.study.chatting.test;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY) - OneToOne 양방향 테스트
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}

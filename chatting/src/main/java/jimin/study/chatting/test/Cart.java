package jimin.study.chatting.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    @Column(name = "cart_id")
    private Long id;
}

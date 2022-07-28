package com.example.test.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long idx;

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String pw;
}

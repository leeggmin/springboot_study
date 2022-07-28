package com.example.test.repository;

import com.example.test.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findById(String id){
        return em.createQuery("select u from User u where u.id = :id",User.class)
                .setParameter("id",id)
                .getSingleResult();
    }

}

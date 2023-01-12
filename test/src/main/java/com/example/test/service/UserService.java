package com.example.test.service;

import com.example.test.domain.User;
import com.example.test.repository.UserRepositoryDataJPA;
import com.example.test.repository.UserRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryJPA userRepository;
    private final UserRepositoryDataJPA userRepositoryDataJPA;

    @Transactional
    public String join(String email, String name, String pw){

        overLayId(email);

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPw(pw);

        userRepositoryDataJPA.save(user);

        return user.getEmail();
    }

    public void overLayId(String email){
        Optional<User> user = userRepositoryDataJPA.findByEmail(email);
        if(user.isPresent()==true){
            throw new RuntimeException("overLayId");
        }
    }

    @Cacheable(value = "user", key = "#id")
    public User readOne(String id){

        Optional<User> user = userRepositoryDataJPA.findByEmail(id);
        return user.get();
    }

    @Cacheable(value = "user")
    public List<User> getList() {
        return userRepositoryDataJPA.findAll();
    }
}

package com.example.test.service;

import com.example.test.domain.User;
import com.example.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String join(String Id, String pw){

        User user = new User();
        user.setId(Id);
        user.setPw(pw);

        userRepository.save(user);

        return user.getId();
    }
}

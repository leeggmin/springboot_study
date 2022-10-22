package jimin.study.chatting.domain.user.service;

import jimin.study.chatting.domain.user.domain.entity.User;
import jimin.study.chatting.domain.user.domain.repository.UserRepository;
import jimin.study.chatting.global.error.CustomError;
import jimin.study.chatting.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            throw CustomError.of(ErrorCode.NOT_FOUND);
        });
    }
}

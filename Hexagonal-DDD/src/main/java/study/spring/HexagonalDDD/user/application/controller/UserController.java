package study.spring.HexagonalDDD.user.application.controller;

import study.spring.HexagonalDDD.user.application.request.CreateUserRequest;
import study.spring.HexagonalDDD.user.domain.port.inbound.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 인바운드 어뎁터
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/join")
    public void createUser(@RequestBody CreateUserRequest createUserRequest) {
        createUserUseCase.createUser(createUserRequest.toDomain());
    }
}

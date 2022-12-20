package study.spring.HexagonalDDD.domain.user.domain.service;

import study.spring.HexagonalDDD.domain.user.domain.port.inbound.CreateUserUseCase;
import study.spring.HexagonalDDD.domain.user.domain.model.User;
import study.spring.HexagonalDDD.domain.user.domain.port.outbound.CreateUserPort;
import lombok.RequiredArgsConstructor;
import study.spring.HexagonalDDD.global.annotation.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;

    @Override
    public void createUser(User user) {
        createUserPort.createUser(user);
    }
}

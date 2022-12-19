package study.spring.HexagonalDDD.user.domain.service;

import org.springframework.stereotype.Service;
import study.spring.HexagonalDDD.user.domain.model.User;
import study.spring.HexagonalDDD.user.domain.port.inbound.CreateUserUseCase;
import study.spring.HexagonalDDD.user.domain.port.outbound.CreateUserPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;

    @Override
    public void createUser(User user) {
        createUserPort.createUser(user);
    }
}

package study.spring.HexagonalDDD.user.domain.port.inbound;

import study.spring.HexagonalDDD.user.domain.model.User;

public interface CreateUserUseCase {

    void createUser(User user);
}

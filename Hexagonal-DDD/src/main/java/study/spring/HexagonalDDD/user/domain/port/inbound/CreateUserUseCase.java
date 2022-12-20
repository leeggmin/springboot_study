package study.spring.HexagonalDDD.user.domain.port.inbound;

import study.spring.HexagonalDDD.user.domain.model.User;

// 인바운드 포트
public interface CreateUserUseCase {

    void createUser(User user);
}

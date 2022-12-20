package study.spring.HexagonalDDD.domain.user.domain.port.inbound;

import study.spring.HexagonalDDD.domain.user.domain.model.User;

// 인바운드 포트
public interface CreateUserUseCase {

    void createUser(User user);
}

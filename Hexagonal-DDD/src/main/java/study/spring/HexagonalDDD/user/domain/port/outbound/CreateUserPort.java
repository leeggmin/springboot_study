package study.spring.HexagonalDDD.user.domain.port.outbound;

import study.spring.HexagonalDDD.user.domain.model.User;

// 아웃바운드 포트
public interface CreateUserPort {

    void createUser(User user);
}

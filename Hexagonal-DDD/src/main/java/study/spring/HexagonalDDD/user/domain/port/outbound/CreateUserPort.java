package study.spring.HexagonalDDD.user.domain.port.outbound;

import study.spring.HexagonalDDD.user.domain.model.User;

public interface CreateUserPort {

    void createUser(User user);
}

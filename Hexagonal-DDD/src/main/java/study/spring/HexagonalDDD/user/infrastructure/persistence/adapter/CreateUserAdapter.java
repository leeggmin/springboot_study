package study.spring.HexagonalDDD.user.infrastructure.persistence.adapter;

import org.springframework.stereotype.Component;
import study.spring.HexagonalDDD.user.domain.model.User;
import study.spring.HexagonalDDD.user.domain.port.outbound.CreateUserPort;
import lombok.RequiredArgsConstructor;
import study.spring.HexagonalDDD.user.infrastructure.persistence.entity.UserJpaEntity;
import study.spring.HexagonalDDD.user.infrastructure.persistence.repository.UserRepository;

// 아웃바운드 어뎁터
@Component
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserPort {

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(UserJpaEntity.builder().user(user).build());
    }
}

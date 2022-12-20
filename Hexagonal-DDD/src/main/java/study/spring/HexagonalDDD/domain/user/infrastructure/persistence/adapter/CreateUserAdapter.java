package study.spring.HexagonalDDD.domain.user.infrastructure.persistence.adapter;

import org.springframework.stereotype.Component;
import study.spring.HexagonalDDD.domain.user.domain.port.outbound.CreateUserPort;
import study.spring.HexagonalDDD.domain.user.infrastructure.persistence.entity.UserJpaEntity;
import study.spring.HexagonalDDD.domain.user.infrastructure.persistence.repository.UserRepository;
import study.spring.HexagonalDDD.domain.user.domain.model.User;
import lombok.RequiredArgsConstructor;

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

package study.spring.HexagonalDDD.user.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.HexagonalDDD.user.infrastructure.persistence.entity.UserJpaEntity;

public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {
}

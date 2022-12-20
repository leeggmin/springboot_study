package study.spring.HexagonalDDD.domain.user.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.spring.HexagonalDDD.domain.user.infrastructure.persistence.entity.UserJpaEntity;

@Repository
public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {
}

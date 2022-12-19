package study.spring.HexagonalDDD.user.infrastructure.persistence.entity;

import study.spring.HexagonalDDD.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {

    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String pw;

    @Builder
    public UserJpaEntity(User user) {

        this.email = user.getEmail();
        this.name = user.getName();
        this.pw = user.getPw();
    }

    public User toDomain() {
        return User.builder()
                .email(email)
                .pw(pw)
                .name(name).build();
    }
}

package study.spring.HexagonalDDD.domain.user.application.request;

import study.spring.HexagonalDDD.domain.user.domain.model.User;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String email;
    private String pw;
    private String name;

    public User toDomain() {
        return User.builder()
                .email(email)
                .pw(pw)
                .name(name).build();
    }
}

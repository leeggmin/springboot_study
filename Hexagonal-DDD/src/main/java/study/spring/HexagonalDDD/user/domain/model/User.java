package study.spring.HexagonalDDD.user.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private String email;

    private String pw;

    private String name;
}

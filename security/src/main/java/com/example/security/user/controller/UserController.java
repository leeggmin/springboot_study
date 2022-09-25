package com.example.security.user.controller;

import com.example.security.jwt.JwtTokenProvider;
import com.example.security.user.domain.User;
import com.example.security.user.domain.UserRepository;
import com.example.security.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    public void join(@RequestBody UserDto userDto){
        userRepository.save(User.builder()
                .uid(userDto.getUid())
                .pw(userDto.getPw())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto, HttpServletResponse httpServletResponse){
        User user = userRepository.findByUid(userDto.getUid()).get();
        String token = jwtTokenProvider.createToken(user.getUid(), user.getRoles());

        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        httpServletResponse.addCookie(cookie);

        return token;
    }
}

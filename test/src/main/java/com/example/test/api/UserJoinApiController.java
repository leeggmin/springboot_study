package com.example.test.api;

import com.example.test.domain.User;
import com.example.test.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserJoinApiController {

    private final UserService userService;

    @PostMapping("/join")
    public JoinUserResponse userJoin(@RequestBody UserDto userRequest){
        String id = userService.join(userRequest.getId(),userRequest.getName(), userRequest.getPw());
        return new JoinUserResponse(id);
    }

    @GetMapping("/readOne/{id}")
    public UserDto userRead(@PathVariable("id")String id){
        User user = userService.readOne(id);
        return new UserDto(user.getId(), user.getName(),user.getPw());
    }

    @Data
    @AllArgsConstructor
    static class UserDto{

        private String id;
        private String name;
        private String pw;

    }

    @Data
    @AllArgsConstructor
    static class JoinUserResponse{

        private String id;

    }

}

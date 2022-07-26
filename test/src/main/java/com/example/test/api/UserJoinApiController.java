package com.example.test.api;

import com.example.test.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJoinApiController {

    private final UserService userService;

    @PostMapping("/join")
    public JoinUserResponse user_join(@RequestBody JoinUserRequest userRequest){
        String id = userService.join(userRequest.getId(), userRequest.getPw());
        return new JoinUserResponse(id);
    }

    @Data
    static class JoinUserRequest{

        private String id;
        private String pw;

        public JoinUserRequest(String id, String pw) {
            this.id = id;
            this.pw = pw;
        }
    }

    @Data
    static class JoinUserResponse{

        private String id;

        public JoinUserResponse(String id) {
            this.id = id;
        }
    }
}

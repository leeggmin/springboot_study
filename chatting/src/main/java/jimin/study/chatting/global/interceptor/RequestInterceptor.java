package jimin.study.chatting.global.interceptor;

import jimin.study.chatting.domain.user.domain.entity.User;
import jimin.study.chatting.global.annotation.CheckToken;
import jimin.study.chatting.global.config.jwt.JwtUtil;
import jimin.study.chatting.global.error.CustomError;
import jimin.study.chatting.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (!(handlerMethod.getMethod().isAnnotationPresent(CheckToken.class))) {
            return true;
        }

        String token = extract(request);

        if(token.isEmpty()) {
            throw CustomError.of(ErrorCode.TOKEN_NOT_PROVIDED);
        }

        User user = jwtUtil.getUserByToken(token);
        request.setAttribute("user", user);

        return true;
    }

    private String extract(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaders("Authorization");

        while (headers.hasMoreElements()) {

            String value = headers.nextElement();
            if (value != null) {
                return value;
            }
        }
        
        return Strings.EMPTY;
    }
}

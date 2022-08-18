package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.repository.UserRepository;
import com.festa.hack.kurly.security.JwtTokenProvider;
import com.festa.hack.kurly.util.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger( UserService.class );

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public ResponseEntity login(User req, HttpServletResponse response) {

        final String email = req.getEmail();
        final String password = req.getPassword();
        if ( ObjectUtils.isEmpty(email) || ObjectUtils.isEmpty(password)) {
            logger.error("email or password is required");
            return RestResponse.fail( HttpStatus.BAD_REQUEST, "이메일을 또는 비밀번호를 입력하세요.");
        }

        User user = userRepository.findUserByEmailAndPassword(email, password)
                .orElseThrow(NoSuchElementException::new);

        String token = null;
        try {
            token = jwtTokenProvider.createToken(user);
        } catch (Exception e) {
            logger.error("create token - email: {}, error: {}", email, e.getMessage());
            return RestResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        if (token == null) {
            logger.error("created token is null - email: {}", email);
            return RestResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, "로그인이 실패하였습니다.");
        }

        response.setHeader("jwt-auth-token", token);

        return RestResponse.success();
    }

    public ResponseEntity logout() {

        return RestResponse.success();
    }

    public ResponseEntity signUp(User req) {
        final String email = req.getEmail();
        final String password = req.getPassword();
        final String name = req.getName();

        User user = User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();

        try {
            userRepository.save(user);
        } catch (Exception e) {
            return RestResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, "회원가입이 실패하였습니다.");
        }

        return RestResponse.success();

    }
}

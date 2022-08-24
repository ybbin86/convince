package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.custom.CustomException;
import com.festa.hack.kurly.repository.UserRepository;
import com.festa.hack.kurly.security.JwtTokenProvider;
import com.festa.hack.kurly.type.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public ResponseEntity login(User req, HttpServletResponse response) {

        final String email = req.getEmail();
        final String password = req.getPassword();

        // 이메일, 비밀번호 필수값 체크
        if ( ObjectUtils.isEmpty(email) || ObjectUtils.isEmpty(password)) {
            log.error("email or password is required");
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        // 가입된 유저 이메일인지 확인
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));

        // 비밀번호를 인코딩한 값과 저장된 비밀번호가 일치하는지 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException(ErrorCode.PASSWORD_INVALID);
        }

        // 토큰 생성
        String token = null;
        try {
            token = jwtTokenProvider.createToken(user);
        } catch (Exception e) {
            log.error("create token - email: {}, error: {}", email, e.getMessage());
            throw new CustomException(ErrorCode.TOKEN_FAILED);
        }

        if (token == null) {
            log.error("created token is null - email: {}", email);
            throw new CustomException(ErrorCode.TOKEN_FAILED);
        }

        // 토큰을 헤더에 담아서 리턴
        response.setHeader("jwt-auth-token", token);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity logout() {

        return ResponseEntity.ok().build();
    }

    public ResponseEntity signUp(User req) {
        final String email = req.getEmail();
        final String password = req.getPassword();
        final String name = req.getName();

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password)) // 패스워드 인코딩
                .name(name)
                .build();

        try {
            userRepository.save(user);
        } catch (DataAccessException e) {
            log.error("user save exception: {}", e.getMessage());
            throw new CustomException(ErrorCode.SIGNUP_FAILED);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

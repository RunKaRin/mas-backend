package com.example.userservice.dto;

import com.example.userservice.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class RequestCreateUserDto {

    @Email
    private String email;

    @Size(min = 8, max = 20,  message = "비밀번호는 8~20글자 입니다.")
    private String pw;

    @NotNull
    private String name;

    @NotNull
    private String userId;

    public User toEntity() {

        // 암호화 비번을 저장하기 위해 필요한 암호화 라이브러리
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .userId(this.userId)
                .encPw(bCryptPasswordEncoder.encode(this.pw))
                .name(this.name)
                .email(this.email)
                .uuid(UUID.randomUUID().toString())
                .createAt(LocalDateTime.now())
                .build();
    }
}

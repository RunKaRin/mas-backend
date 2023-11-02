package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-service")
public class UserController {

    private final UserService userService;

    @RequestMapping("health-check")
    public String healthCheck() {
        return "server is available!";
    }

    @RequestMapping("health-check2") // 확인용 임시 생성
    public String healthCheck2() {
        return "server is available!";
    }

    // 회원가입
    @PostMapping ("users")
    public ResponseEntity<?> createUser(@Valid @RequestBody RequestCreateUserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
        // 200 OK: 성공적으로 처리했을 때 쓰인다
        // 201 Created: 요청이 성공적으로 처리되어서 리소스가 만들어졌음.
    }

    // 전체 회원 조회
    @GetMapping("users/all")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    // uuid 기준 user 조회
    @GetMapping("users/{uuid}")
    public ResponseEntity<?> findUserByUuid(@PathVariable String uuid) {
        ResponseFindUserDto user = userService.findUserByUuid(uuid);
        return ResponseEntity.ok(user);
    }

    // userId 기준 orderList 조회
    @GetMapping("users/{userId}/orders")
    public ResponseEntity<?> findOrdersByUserId(@PathVariable String userId) {
        ResponseFindUserDto userDto = userService.findUserOrderList(userId);
        return ResponseEntity.ok(userDto);
    }
}

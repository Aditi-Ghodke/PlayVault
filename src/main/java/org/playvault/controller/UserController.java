package org.playvault.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.playvault.dto.LoginReqDto;
import org.playvault.dto.ManagerReqDto;
import org.playvault.dto.UserRequestDto;
import org.playvault.dto.UserUpdateDto;
import org.playvault.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Validated
public class UserController {
    private UserService userService;

    //REGISTER MANGER
    @PostMapping("/manager/register")
    public ResponseEntity<?> registerManager(@Valid @RequestBody ManagerReqDto managerReqDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registerManager(managerReqDto));
    }

    //REGISTER USER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registerUser(userRequestDto));
    }

    //LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginReqDto loginReqDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.userLogin(loginReqDto));
    }

    //UPDATE USER
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(userId, userUpdateDto));
    }

    //GET USER BY USERID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserById(userId));
    }

    //GET ALL USERS
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    //DELETE USER BY USERID
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
        return  ResponseEntity.status(HttpStatus.OK)
                .body(userService.deleteUser(userId));
    }

}

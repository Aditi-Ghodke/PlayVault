package org.playvault.service;

import org.playvault.dto.*;
import org.playvault.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser(UserRequestDto user);
    UserResponseDto registerManager(ManagerReqDto managerReqDto);
    UserResponseDto userLogin(LoginReqDto user);
    //String changePassword(String oldPassword, String newPassword);
    UserResponseDto updateUser(Long id, UserUpdateDto user);
    ApiResponse deleteUser(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
}

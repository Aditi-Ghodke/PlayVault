package org.playvault.service;

import org.playvault.dto.LoginReqDto;
import org.playvault.dto.ManagerReqDto;
import org.playvault.dto.UserReqDto;
import org.playvault.dto.UserResponseDto;
import org.playvault.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto registerUser(UserReqDto user);
    UserResponseDto registerManager(ManagerReqDto managerReqDto);
    UserResponseDto userLogin(LoginReqDto user);
    //String changePassword(String oldPassword, String newPassword);
    UserResponseDto updateUser(Long id, UserReqDto user);
    User deleteUser(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
}

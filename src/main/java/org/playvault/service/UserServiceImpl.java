package org.playvault.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.playvault.dao.UserDao;
import org.playvault.dto.LoginReqDto;
import org.playvault.dto.ManagerReqDto;
import org.playvault.dto.UserReqDto;
import org.playvault.dto.UserResponseDto;
import org.playvault.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public UserResponseDto registerUser(UserReqDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saved = userDao.save(user);
        return null;
    }

    @Override
    public UserResponseDto registerManager(ManagerReqDto managerReqDto) {
        return null;
    }


    @Override
    public UserResponseDto userLogin(LoginReqDto user) {
        return null;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserReqDto user) {
        return null;
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return null;
    }
}
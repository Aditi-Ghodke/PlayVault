package org.playvault.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.playvault.custom_exceptions.ApiException;
import org.playvault.custom_exceptions.ResourceNotFoundException;
import org.playvault.dao.UserDao;
import org.playvault.dto.*;
import org.playvault.entity.Role;
import org.playvault.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    @Override
    public UserResponseDto registerUser( UserRequestDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        User saved = userDao.save(user);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    @Override
    public UserResponseDto registerManager(ManagerReqDto managerReqDto) {
        User manager = modelMapper.map(managerReqDto, User.class);
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setRole(Role.MANAGER);
        User saved = userDao.save(manager);
        return modelMapper.map(saved, UserResponseDto.class);
    }


    @Override
    public UserResponseDto userLogin(LoginReqDto userDto) {
        User user = userDao.findByEmail(userDto.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("User not foud!"));
        if(!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new ApiException("Wrong password!");
        }
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateDto userDto) {
        User user = userDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not foud!"));
        modelMapper.map(userDto, user);
        userDao.save(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        User user = userDao.findById(id).orElseThrow(()->new ResourceNotFoundException("User not foud!"));
        userDao.delete(user);
        return new ApiResponse("User has been deleted!");
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userDao.findAll();
        if(users.isEmpty()) {
            throw new ResourceNotFoundException("User not foud!");
        }
        return users.stream()
                .map(user -> {
                    return modelMapper.map(user, UserResponseDto.class);
                }).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        return userDao.findById(id)
                .map(user->{
                    UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
                    return userResponseDto;
                })
                .orElseThrow(()->new ResourceNotFoundException("User not foud!"));
    }
}
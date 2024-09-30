package com.aravind.userinfo.service;

import com.aravind.userinfo.Dto.UserDto;
import com.aravind.userinfo.mapper.UserMapper;
import com.aravind.userinfo.model.User;
import com.aravind.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }


    public ResponseEntity<UserDto> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        if(fetchedUser.isPresent())
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(fetchedUser.get()), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

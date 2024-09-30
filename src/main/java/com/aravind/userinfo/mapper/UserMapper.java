package com.aravind.userinfo.mapper;

import com.aravind.userinfo.Dto.UserDto;
import com.aravind.userinfo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);

}

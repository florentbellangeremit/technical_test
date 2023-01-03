package com.bellanger.technical_test.mapper;

import com.bellanger.technical_test.dao.entity.User;
import com.bellanger.technical_test.dto.request.UserRequest;
import com.bellanger.technical_test.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(User user);

    User userRequestToUser(UserRequest userRequest);

}

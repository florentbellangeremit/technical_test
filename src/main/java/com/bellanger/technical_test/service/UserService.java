package com.bellanger.technical_test.service;

import com.bellanger.technical_test.dao.repository.UserRepository;
import com.bellanger.technical_test.dto.request.UserRequest;
import com.bellanger.technical_test.dto.response.UserResponse;
import com.bellanger.technical_test.exception.object.EntityAlreadyExistException;
import com.bellanger.technical_test.exception.object.EntityNotExistException;
import com.bellanger.technical_test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long createUser(UserRequest userRequest) {
        if (userRepository.findByUsernameAndBirthdateAndCountry(userRequest.getUsername(), userRequest.getBirthdate(),
                userRequest.getCountry()).isPresent()) {
            throw new EntityAlreadyExistException("User already exist");
        }
        var entity = userRepository.save(userMapper.userRequestToUser(userRequest));
        return entity.getId();
    }

    public UserResponse getUser(long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new EntityNotExistException("User not found"));
        return userMapper.userToUserResponse(user);
    }
}

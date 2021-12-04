package com.bci.users.services;

import com.bci.users.dto.UserRequestDTO;
import com.bci.users.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO save(UserRequestDTO userRequest) throws Exception;

}

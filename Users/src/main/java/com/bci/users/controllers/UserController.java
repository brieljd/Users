package com.bci.users.controllers;

import javax.validation.Valid;

import com.bci.users.services.UserService;
import com.bci.users.dto.UserRequestDTO;
import com.bci.users.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) throws Exception {

        ResponseEntity response;

        try {
            UserResponseDTO userResponseDTO = userService.save(userRequestDTO);
            response = new ResponseEntity(userResponseDTO, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("error " + e);
            e.printStackTrace();
            throw e;

        }
        return response;
    }
}
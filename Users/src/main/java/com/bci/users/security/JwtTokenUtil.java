package com.bci.users.security;

import java.io.Serializable;
import java.util.Date;

import com.bci.users.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -4211581360290344026L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    @Value("${jwt}")
    private  String jwtValue;
    public String generateToken(UserRequestDTO userRequestDTO) {
        return Jwts.builder().setSubject(userRequestDTO.getName()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtValue).compact();
    }


}
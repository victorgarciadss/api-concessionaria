package com.api.dealership.controller;

import com.api.dealership.config.security.TokenService;
import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.LoginResponseDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.repository.LoginRepository;
import com.api.dealership.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/cadastro")
    public Login registerUser(@RequestBody RegisterDto registerDto){
        return authorizationService.registerUser(registerDto);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDto> makeLogin(@RequestBody AuthorizationDto authorizationDto){
        LoginResponseDto loginData = authorizationService.makeLogin(authorizationDto, authenticationManager);

        return ResponseEntity.ok().body(loginData);
    }
}

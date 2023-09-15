package com.api.dealership.controller;

import com.api.dealership.config.security.TokenService;
import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.repository.LoginRepository;
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
    private LoginRepository loginRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/cadastro")
    public Login registerUser(@RequestBody RegisterDto registerDto){
        UserDetails user = loginRepository.findByUserName(registerDto.userName());

        if(user != null){
            throw new IllegalArgumentException("Usuário já está cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        Login newUser = new Login(registerDto.userName(), encryptedPassword, registerDto.role());

        return loginRepository.save(newUser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> makeLogin(@RequestBody AuthorizationDto authorizationDto){
        UsernamePasswordAuthenticationToken dataHash = new UsernamePasswordAuthenticationToken(authorizationDto.userName(), authorizationDto.password());
        Authentication auth = authenticationManager.authenticate(dataHash);

        String token = tokenService.generateToken((Login) auth.getPrincipal());

        return ResponseEntity.ok().body(token);
    }
}

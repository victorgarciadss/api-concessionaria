package com.api.dealership.controller;

import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

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
}

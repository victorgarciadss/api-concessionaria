package com.api.dealership.service;

import com.api.dealership.config.security.TokenService;
import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepository.findByUserName(username);
    }

    public Login registerUser(RegisterDto data){
        UserDetails user = loginRepository.findByUserName(data.userName());

        if(user != null){
            throw new IllegalArgumentException("Usuário já está cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Login newUser = new Login(data.userName(), encryptedPassword, data.role());

        return loginRepository.save(newUser);
    }

    public String makeLogin(AuthorizationDto auth, AuthenticationManager manager){
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(auth.userName(), auth.password());
        Authentication authentication = manager.authenticate(credentials);

        return tokenService.generateToken((Login) authentication.getPrincipal());
    }
}

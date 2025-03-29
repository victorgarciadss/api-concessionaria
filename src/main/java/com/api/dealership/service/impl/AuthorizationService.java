package com.api.dealership.service.impl;

import com.api.dealership.config.security.TokenService;
import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.EmployeeDto;
import com.api.dealership.dto.LoginResponseDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.pages.PaginationData;
import com.api.dealership.repository.LoginRepository;
import com.api.dealership.service.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService, IAuthorizationService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepository.findByUserName(username);
    }

    @Override
    public PaginationData<EmployeeDto> getEmployees(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<EmployeeDto> employees = loginRepository
                .findAll(pageRequest)
                .map(employee -> new EmployeeDto(employee.getId(), employee.getUsername(), employee.getRole()));

        PaginationData<EmployeeDto> pagedEmployees = new PaginationData<EmployeeDto>(employees.getContent(), Math.toIntExact(employees.getTotalElements()));

        return pagedEmployees;
    }

    @Override
    public Login registerUser(RegisterDto data){
        UserDetails user = loginRepository.findByUserName(data.userName());

        if(user != null){
            throw new IllegalArgumentException("Usuário já está cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Login newUser = new Login(data.userName(), encryptedPassword, data.role());

        return loginRepository.save(newUser);
    }

    @Override
    public LoginResponseDto makeLogin(AuthorizationDto auth, AuthenticationManager manager){
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(auth.userName(), auth.password());
        Authentication authentication = manager.authenticate(credentials);

        Login user = (Login) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        String role = user.getAuthorities()
                        .stream()
                        .map(authority -> authority.getAuthority())
                        .findFirst()
                        .orElse("Sem role");


        return new LoginResponseDto(token, role);
    }
}

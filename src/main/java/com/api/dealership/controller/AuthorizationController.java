package com.api.dealership.controller;

import com.api.dealership.controller.docsInterfaces.AuthorizationControllerDoc;
import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.EmployeeDto;
import com.api.dealership.dto.LoginResponseDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.pages.PaginationData;
import com.api.dealership.service.impl.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthorizationController implements AuthorizationControllerDoc {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    @GetMapping(value = "/paginado")
    public PaginationData<EmployeeDto> getEmployees(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return authorizationService.getEmployees(page, size);
    }

    @Override
    @PostMapping(value = "/cadastro")
    public Login registerUser(@RequestBody RegisterDto registerDto){
        return authorizationService.registerUser(registerDto);
    }

    @Override
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDto> makeLogin(@RequestBody AuthorizationDto authorizationDto){
        LoginResponseDto loginData = authorizationService.makeLogin(authorizationDto, authenticationManager);

        return ResponseEntity.ok().body(loginData);
    }
}

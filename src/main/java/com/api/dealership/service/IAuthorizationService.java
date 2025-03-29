package com.api.dealership.service;

import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.EmployeeDto;
import com.api.dealership.dto.LoginResponseDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.pages.PaginationData;
import org.springframework.security.authentication.AuthenticationManager;

public interface IAuthorizationService {

    /**
     * Esse método é responsável por exibir os funcionários de forma páginada
     * @param page número da página a ser exibida
     * @param size numero de elementos na página
     * @return retorna os elementos páginados
     */
    public PaginationData<EmployeeDto> getEmployees(Integer page, Integer size);

    /**
     * Esse metodo é responsável por cadastrar um novo funcionário
     * @param data os dados do usuário que serão registrados
     * @return retorna os dados do usuário registrado
     */
    public Login registerUser(RegisterDto data);

    /**
     * Metodo responsável por realizar o login do funcionário
     * @param auth as credenciais necessárias para o processo de login
     * @param manager objeto que autentica as credenciais
     * @return retorna o Token e a Role do usuário
     */
    public LoginResponseDto makeLogin(AuthorizationDto auth, AuthenticationManager manager);
}

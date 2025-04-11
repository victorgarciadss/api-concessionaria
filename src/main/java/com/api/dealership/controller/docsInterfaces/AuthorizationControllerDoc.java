package com.api.dealership.controller.docsInterfaces;

import com.api.dealership.dto.AuthorizationDto;
import com.api.dealership.dto.EmployeeDto;
import com.api.dealership.dto.LoginResponseDto;
import com.api.dealership.dto.RegisterDto;
import com.api.dealership.entity.logins.Login;
import com.api.dealership.pages.PaginationData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthorizationControllerDoc {

    @Operation(summary = "Lista funcionários paginados", description = "Retorna lista páginada dos funcionários cadastrados no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada com tamanho e no lugar correto"),
                    @ApiResponse(responseCode = "400", description = "Erro devido a parametrização incorreta"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa rota"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public PaginationData<EmployeeDto> getEmployees(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size);

    @Operation(summary = "Cadastra um novo funcionário", description = "Cadastra as informações do funcionário")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna o funcionário cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro no corpo da requisição"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa rota"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public ResponseEntity<Login> registerUser(@RequestBody RegisterDto registerDto);

    @Operation(summary = "Realiza login", description = "Realiza o login do funcionário")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que login foi feito corretamente"),
                    @ApiResponse(responseCode = "400", description = "Erro no corpo da requisição"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public ResponseEntity<LoginResponseDto> makeLogin(@RequestBody AuthorizationDto authorizationDto);
}


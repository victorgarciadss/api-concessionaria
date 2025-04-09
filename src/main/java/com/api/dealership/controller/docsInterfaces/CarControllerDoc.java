package com.api.dealership.controller.docsInterfaces;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarControllerDoc {

    @Operation(summary = "Listar carros", description = "Lista todos os carros do banco")
    @ApiResponse(responseCode = "200", description = "Retorna a lista corretamente")
    public List<Car> getAllCars();

    @Operation(summary = "Lista um carro", description = "Retorna um carro pelo seu Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Carro retornado com sucesso pelo id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa informação"),
                    @ApiResponse(responseCode = "404", description = "Carro não encontrado no sistema")
            }
    )
    public Car getCarById(@PathVariable("id") Long id);

    @Operation(summary = "Cadastra um carro", description = "Cadastra as informações do carro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna que o carro foi inserido corretamente"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para inserir essa informação")
            }
    )
    public Car createCar(@Valid @RequestBody CarDto carDto);

    @Operation(summary = "Atualiza um carro", description = "Atualiza as informações de um carro pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o carro atualiza com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para atualizar essa informação"),
                    @ApiResponse(responseCode = "404", description = "Carro não encontrado no sistema")
            }
    )
    public Car updateCar(@PathVariable("id") Long id, @Valid @RequestBody CarDto carDto);

    @Operation(summary = "Deleta um carro", description = "Deleta um carro pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que o carro foi deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Erro devido ao id do carro não ter sido encontrado")
            }
    )
    public void deleteCar(@PathVariable("id") Long id);
}

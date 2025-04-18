package com.api.dealership.controller.docsInterfaces;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.pages.PaginationData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarControllerDoc {

    @Operation(summary = "Listar carros", description = "Lista todos os carros do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista corretamente"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public List<Car> getAllCars();

    @Operation(summary = "Lista carros paginados", description = "Retorna uma lista páginada e parmetrizada dos carros cadastrados no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada com tamanho e no lugar correto"),
                    @ApiResponse(responseCode = "400", description = "Erro devido a parametrização incorreta"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public PaginationData<Car> getCars(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size);

    @Operation(summary = "Lista um carro", description = "Retorna um carro pelo seu Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Carro retornado com sucesso pelo id"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Carro não encontrado no sistema"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public Car getCarById(@PathVariable("id") Long id);

    @Operation(summary = "Cadastra um carro", description = "Cadastra as informações do carro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna que o carro foi inserido corretamente"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para inserir essa informação"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDto carDto);

    @Operation(summary = "Atualiza um carro", description = "Atualiza as informações de um carro pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o carro atualizado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Carro não encontrado no sistema"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public Car updateCar(@PathVariable("id") Long id, @Valid @RequestBody CarDto carDto);

    @Operation(summary = "Deleta um carro", description = "Deleta um carro pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que o carro foi deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Erro devido ao id do carro não ter sido encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    public void deleteCar(@PathVariable("id") Long id);
}

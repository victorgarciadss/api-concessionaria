package com.api.dealership.controller.docsInterfaces;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Client;
import com.api.dealership.pages.PaginationData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientControllerDoc {

    @Operation(summary = "Lista clientes", description = "Retorna todos os clientes no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada corretamente"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota")
            }
    )
    public List<Client> getAllClients();

    @Operation(summary = "Lista páginada de clientes", description = "Retorna uma lista páginada e parâmetrizada de clientes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista retornada com tamanho e no lugar correto"),
                    @ApiResponse(responseCode = "400", description = "Erro devido a parametrização incorreta"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota")
            }
    )
    public PaginationData<Client> getClients(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size);

    @Operation(summary = "Lista um Cliente", description = "Retorna um cliente pelo seu Id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cliente retornado com sucesso pelo id"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado no sistema")
            }
    )
    public Client getClientById(@PathVariable("id") Long id);

    @Operation(summary = "Cadastra um cliente", description = "Cadastra as informações do cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna que o cliente foi cadastrado corretamente"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota")
            }
    )
    public ResponseEntity<Client> insertClient(@Valid @RequestBody ClientDto clientDto);

    @Operation(summary = "Atualiza um cliente", description = "Atualiza as informações do cliente pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o cliente atualizado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Há dados faltando no corpo da requisição"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado no sistema")
            }
    )
    public Client updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDto clientDto);

    @Operation(summary = "Deleta um cliente", description = "Deleta um cliente pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que o cliente foi deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Erro devido ao id do cliente não ter sido encontrado")
            }
    )
    public void deleteClient(@PathVariable("id") Long id);

    @Operation(summary = "Realiza a compra de um carro", description = "Realiza a compra de um carro para o cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que a compra do carro foi concluída corretamente"),
                    @ApiResponse(responseCode = "400", description = "Alguma validação não está sendo cumprida ou falta algum dado no corpo da requisição"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Cliente ou carro não estão cadastrados no sistema")
            }
    )
    public void makesPurchase(@Valid @RequestBody SaleDto saleDto);
}

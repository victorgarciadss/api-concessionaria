package com.api.dealership.controller.docsInterfaces;

import com.api.dealership.projections.SoldCarProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SaleControllerDoc {

    @Operation(summary = "Lista vendas", description = "Lista todas as vendas já realizadas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todas as vendas corretamente"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota")
            }
    )
    public List<SoldCarProjection> getAllSales();

    @Operation(summary = "Lista venda específica", description = "Retorna uma venda pelo ID do cliente e ID do carro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Venda retornada com sucesso pelo id"),
                    @ApiResponse(responseCode = "401", description = "User deve se autenticar para acessar essa rota"),
                    @ApiResponse(responseCode = "404", description = "Venda não encontrada no sistema")
            }
    )
    public SoldCarProjection getSaleById(@PathVariable("carId") Long carId, @PathVariable("buyerId") Long buyerId);
}

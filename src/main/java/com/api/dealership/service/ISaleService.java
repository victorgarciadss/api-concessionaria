package com.api.dealership.service;

import java.util.List;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Sale;
import com.api.dealership.projections.SoldCarProjection;

public interface ISaleService {
    
    /**
     * Esse método busca todas as vendas realizadas do banco de dados
     * @return a lista de vendas realizadas
     */
    public List<SoldCarProjection> getAll();
    
    /**
     * Esse método busca uma venda especíica pelo seu id
     * @param1 id do carro da venda desejada
     * @param2 id do comprador da venda desejada
     * @return retorna uma venda através do id passado
     */
    public SoldCarProjection getSaleById(Long carId, Long buyerId);

    /**
     * Esse método é responsável por efetivar a venda e salvá-la no banco de dados através dos dados passados
     * @param saleDto os dados passados pelo corpo da requisição
     * @return a venda realizada
     */
    public Sale makesSale(SaleDto saleDto);



}

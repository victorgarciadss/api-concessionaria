package com.api.dealership.service;

import java.util.List;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.dto.SoldCarDto;
import com.api.dealership.entity.Sale;
import com.api.dealership.entity.SalePK;

public interface ISaleService {
    
    /**
     * Esse método busca todas as vendas realizadas do banco de dados
     * @return a lista de vendas realizadas
     */
    public List<SoldCarDto> getAll();
    
    /**
     * Esse método busca uma venda especíica pelo seu id
     * @param id da venda desejada
     * @return retorna uma venda através do id passado
     */
    public Sale getSaleById(SalePK id);

    /**
     * Esse método é responsável por efetivar a venda e salvá-la no banco de dados através dos dados passados
     * @param saleDto os dados passados pelo corpo da requisição
     * @return a venda realizada
     */
    public Sale makesSale(SaleDto saleDto);

    /**
     * Esse método atualiza uma venda no banco de dados
     * @param id da venda a ser atualizada
     * @param saleDto dados que podem serem alterados
     * @return retorna a venda atualizada
     */
    public Sale updateSale(SalePK id, SaleDto saleDto);
    
    /**
     * Esse método exclui uma venda do branco de dados
     * @param id da venda que será deletada
     */
    public void deleteSale(SalePK id);


}

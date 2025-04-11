package com.api.dealership.controller;

import java.util.List;

import com.api.dealership.controller.docsInterfaces.SaleControllerDoc;
import com.api.dealership.pages.PaginationData;
import com.api.dealership.projections.SoldCarProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.dealership.service.impl.SaleService;

@RestController
@RequestMapping("/vendas")
public class SaleController implements SaleControllerDoc {
    
    @Autowired
    private SaleService saleService;

    @Override
    @GetMapping
    public List<SoldCarProjection> getAllSales(){
        return saleService.getAll();
    }

    @Override
    @GetMapping("/paginado")
    public PaginationData<SoldCarProjection> getSales(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return saleService.getSales(page, size);
    }

    @Override
    @GetMapping("/carro/{carId}/comprador/{buyerId}")
    public SoldCarProjection getSaleById(@PathVariable("carId") Long carId, @PathVariable("buyerId") Long buyerId){
        return saleService.getSaleById(carId, buyerId);
    }

    

    
}

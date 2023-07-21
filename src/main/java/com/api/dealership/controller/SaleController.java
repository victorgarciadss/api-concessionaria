package com.api.dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dealership.dto.SoldCarDto;
import com.api.dealership.service.impl.SaleService;

@RestController
@RequestMapping("/vendas")
public class SaleController {
    
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SoldCarDto> getAllSales(){
        return saleService.getAll();
    }

    

    
}

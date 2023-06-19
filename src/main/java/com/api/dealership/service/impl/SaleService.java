package com.api.dealership.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Sale;
import com.api.dealership.entity.SalePK;
import com.api.dealership.repository.CarRepository;
import com.api.dealership.repository.SaleRepository;
import com.api.dealership.service.ISaleService;

public class SaleService implements ISaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(SalePK id) {
        return saleRepository.findById(id).get();
    }

    @Override
    public Sale makesSale(SaleDto saleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makesSale'");
    }

    @Override
    public Sale updateSale(Long id, SaleDto saleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSale'");
    }

    @Override
    public void deleteSale(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSale'");
    }
    
}

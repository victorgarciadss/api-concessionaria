package com.api.dealership.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Car;
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
        Car carSold = carRepository.findById(saleDto.getCarId()).get();

        Sale sale = new Sale(saleDto.getCarId(), saleDto.getBuyerId());
        sale.setSaleDate(new Date());
        sale.setValue(carSold.getPrice());

        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(SalePK id, SaleDto saleDto) {
        Sale saleToUpdate = saleRepository.findById(id).get();

        saleToUpdate.setId(new SalePK(saleDto.getCarId(), saleDto.getBuyerId()));

        return saleRepository.save(saleToUpdate);
    }

    @Override
    public void deleteSale(SalePK id) {
        saleRepository.deleteById(id);
    }
    
}

package com.api.dealership.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Car;
import com.api.dealership.entity.Client;
import com.api.dealership.entity.Sale;
import com.api.dealership.projections.SoldCarProjection;
import com.api.dealership.repository.CarRepository;
import com.api.dealership.repository.ClientRepository;
import com.api.dealership.repository.SaleRepository;
import com.api.dealership.service.ISaleService;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<SoldCarProjection> getAll() {
        return saleRepository.findAllSales();
    }

    @Override
    public SoldCarProjection getSaleById(Long carId, Long buyerId) {
        SoldCarProjection soldCar = saleRepository.findById(carId, buyerId);

        if(soldCar == null) {
            throw new NoSuchElementException("Cliente ou carro não encontrados");
        }

        return soldCar;
    }

    @Override
    public Sale makesSale(SaleDto saleDto) {
        Car carSold = carRepository.findById(saleDto.getCarId()).get();
        Client buyer = clientRepository.findById(saleDto.getBuyerId()).get();

        Sale sale = new Sale(carSold, buyer);
        sale.setSaleDate(new Date());
        sale.setValue(carSold.getPrice());

        return saleRepository.save(sale);
    }

    
    
}

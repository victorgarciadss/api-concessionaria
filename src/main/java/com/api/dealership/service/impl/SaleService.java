package com.api.dealership.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Car;
import com.api.dealership.entity.Client;
import com.api.dealership.entity.Sale;
import com.api.dealership.entity.SalePK;
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
        Client buyer = clientRepository.findById(saleDto.getBuyerId()).get();

        Sale sale = new Sale(carSold, buyer);
        sale.setSaleDate(new Date());
        sale.setValue(carSold.getPrice());

        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(SalePK id, SaleDto saleDto) {
        Sale saleToUpdate = saleRepository.findById(id).get();
        Car carSoldUpdate = carRepository.findById(saleDto.getCarId()).get();
        Client buyerToUpdate = clientRepository.findById(saleDto.getBuyerId()).get();

        saleToUpdate.setId(new SalePK(carSoldUpdate, buyerToUpdate));

        return saleRepository.save(saleToUpdate);
    }

    @Override
    public void deleteSale(SalePK id) {
        saleRepository.deleteById(id);
    }
    
}

package com.api.dealership.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.repository.CarRepository;
import com.api.dealership.service.ICarService;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public Car getCarById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarById'");
    }

    @Transactional
    @Override
    public Car insertCar(CarDto carDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCar'");
    }

    @Override
    public Car updateCar(Long id, CarDto carDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCar'");
    }

    @Override
    public void deleteCar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCar'");
    }
    
}

package com.api.dealership.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Car insertCar(CarDto carDto) {
        Car car = new Car();
        BeanUtils.copyProperties(carDto, car);
        return carRepository.save(car);
    }

    @Transactional
    @Override
    public Car updateCar(Long id, CarDto carDto) {
        Car carToUpdate = getCarById(id);

        carToUpdate.setModelName(carDto.getModelName());
        carToUpdate.setBrand(carDto.getBrand());
        carToUpdate.setColor(carDto.getColor());
        carToUpdate.setLaunchYear(carDto.getLaunchYear());
        carToUpdate.setPrice(carDto.getPrice());
        carToUpdate.setPotency(carDto.getPotency());

        return carRepository.save(carToUpdate);
    }

    @Transactional
    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    
}

package com.api.dealership.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.api.dealership.pages.PaginationData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public PaginationData<Car> getCars(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Car> pagedData = carRepository.findAll(pageRequest);

        PaginationData<Car> pagedCars = new PaginationData<>(pagedData.getContent(), Math.toIntExact(pagedData.getTotalElements()));
        return pagedCars;
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
        Optional<Car> carFounded = carRepository.findById(id);

        if(carFounded.isPresent()) {
            carRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Id do carro a ser apagado não foi encontrado");
        }
    }

    @Transactional
    public void incrementSoldAmount(Long carId) {
        Car soldCar = getCarById(carId);
        soldCar.setSoldAmount(soldCar.getSoldAmount() + 1);
        carRepository.save(soldCar);
    }
}

package com.api.dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.service.impl.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carros")
public class CarController {
    
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Car getCarById(@PathVariable("id") Long id){
        return carService.getCarById(id);
    }

    @PostMapping
    public Car createCar(@Valid @RequestBody CarDto carDto){
        return carService.insertCar(carDto);
    }

    @PutMapping(value = "/{id}")
    public Car updateCar(@PathVariable("id") Long id, @Valid @RequestBody CarDto carDto){
        return carService.updateCar(id, carDto);
    }
}

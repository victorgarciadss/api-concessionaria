package com.api.dealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public Car createCar(@Valid @RequestBody CarDto carDto){
        return carService.insertCar(carDto);
    }
}

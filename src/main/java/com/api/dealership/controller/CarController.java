package com.api.dealership.controller;

import java.util.List;

import com.api.dealership.controller.docsInterfaces.CarControllerDoc;
import com.api.dealership.pages.PaginationData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.service.impl.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carros")
public class CarController implements CarControllerDoc {
    
    @Autowired
    private CarService carService;

    @Override
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAll();
    }

    @Override
    @GetMapping("/paginado")
    public PaginationData<Car> getCars(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return carService.getCars(page, size);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Car getCarById(@PathVariable("id") Long id){
        return carService.getCarById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDto carDto){
        Car createdCar = carService.insertCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @Override
    @PutMapping(value = "/{id}")
    public Car updateCar(@PathVariable("id") Long id, @Valid @RequestBody CarDto carDto){
        return carService.updateCar(id, carDto);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }
}

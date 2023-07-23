package com.api.dealership.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.repository.CarRepository;
import com.api.dealership.service.impl.CarService;

@SpringBootTest
public class CarServiceTest {

    private CarDto carDto;

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepositoryMock;

    @BeforeEach
    public void setUp(){
        carDto = new CarDto(
            "Uno", "Fiat", "Branco", 2010, 30000.00, 130
        );

        
    }

    @Test
    public void shouldInsertCar(){
        when(carRepositoryMock.save(any(Car.class))).thenAnswer(invocation -> {
            Car carArgument = invocation.getArgument(0);
            carArgument.setId(15L); // Simula um ID gerado pelo banco de dados
            return carArgument;
        });

        Car result = carService.insertCar(carDto);


        assertNotNull(result);
        assertNotNull(result.getId()); // Verifica se o ID gerado não é nulo
        assertEquals(result.getModelName(), carDto.getModelName());
        verify(carRepositoryMock).save(any(Car.class));
        
        
        
    }
}

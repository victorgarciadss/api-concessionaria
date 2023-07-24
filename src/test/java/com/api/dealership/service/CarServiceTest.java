package com.api.dealership.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
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

    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setUp(){

        cars.add(new Car(16L, "Gol", "Volkswagen", "Branco", 2015,
        25000.00, 100, 0));

        cars.add(new Car(17L, "Mobi", "Fiat", "Amarelo", 2023, 
        70000.00, 150, 0));

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

    @Test
    public void shouldListAllCars(){

        when(carRepositoryMock.findAll()).thenReturn(cars);

        carService.getAll();

        verify(carRepositoryMock).findAll();
        verifyNoMoreInteractions(carRepositoryMock);
    }

    @Test
    public void shouldGetOneCar(){

        Long id = 17L;

        when(carRepositoryMock.findById(id)).thenReturn(Optional.of(cars.get(1)));

        Car carResult = carService.getCarById(id);

        verify(carRepositoryMock).findById(id);
        assertEquals(carResult.getId(), cars.get(1).getId());
    }

    @Test
    public void shouldUpdateCar(){

        Car originalCar = cars.get(0);

        when(carRepositoryMock.findById(any(Long.class))).thenReturn(Optional.of(originalCar));
        when(carRepositoryMock.save(any(Car.class)))
            .thenAnswer((InvocationOnMock invocation) -> invocation.getArgument(0));;

        Car result = carService.updateCar(originalCar.getId(), carDto);

        assertNotNull(result);
        assertEquals(result.getId(), originalCar.getId());
        
        
        verify(carRepositoryMock).save(any(Car.class));
    }

    @Test
    public void shouldDeleteCar(){
        Car carToDelete = cars.get(0);

        doNothing().when(carRepositoryMock).deleteById(any(Long.class));

        carService.deleteCar(carToDelete.getId());

        verify(carRepositoryMock).deleteById(carToDelete.getId());
        verifyNoMoreInteractions(carRepositoryMock);
    }
}

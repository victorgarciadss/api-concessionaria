package com.api.dealership.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.http.MediaType.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.service.impl.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {
    
    // @Autowired
    // private CarController carController;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CarService carServiceMock;

    @Autowired
    private MockMvc mockMvc;

    private List<Car> mockCars = new ArrayList<>();

    private CarDto carDto;

    private Car carToInsert;

    @BeforeEach
    public void setUp(){
        mockCars.add(new Car(16L, "Gol", "Volkswagen", "Branco", 2015,
        25000.00, 100, 0));

        mockCars.add(new Car(17L, "Mobi", "Fiat", "Amarelo", 2023, 
        70000.00, 150, 0));

        carDto = new CarDto("Mobi", "Fiat", "Amarelo", 2022, 45000.00, 150);

        carToInsert = new Car(carDto);
        carToInsert.setId(18L);
        carToInsert.setSoldAmount(0);
    }
    
    @Test
    public void shouldListAllCarsInGetRequest() throws Exception{

        when(carServiceMock.getAll()).thenReturn(mockCars);

        mockMvc.perform(get("/carros"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON));

        verify(carServiceMock).getAll();
    }

    @Test
    public void shouldListOneCarInGetRequest() throws Exception{

        when(carServiceMock.getCarById(17L)).thenReturn(mockCars.get(1));

        mockMvc.perform(get("/carros/{id}", mockCars.get(1).getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andReturn();

        verify(carServiceMock).getCarById(mockCars.get(1).getId());
        verifyNoMoreInteractions(carServiceMock);
        
    }

    @Test
    public void shouldInsertCarInPostRequest() throws Exception {
        when(carServiceMock.insertCar(eq(carDto))).thenReturn(carToInsert);

        mockMvc.perform(post("/carros")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carDto))
        )
        .andExpect(status().isOk());

        verify(carServiceMock).insertCar(eq(carDto));
        verifyNoMoreInteractions(carServiceMock);
    }
}

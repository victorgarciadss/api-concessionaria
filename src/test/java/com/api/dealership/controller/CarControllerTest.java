package com.api.dealership.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.api.dealership.entity.Car;
import com.api.dealership.service.impl.CarService;


@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {
    
    // @Autowired
    // private CarController carController;

    @MockBean
    private CarService carServiceMock;

    @Autowired
    private MockMvc mockMvc;

    private List<Car> mockCars = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        mockCars.add(new Car(16L, "Gol", "Volkswagen", "Branco", 2015,
        25000.00, 100, 0));

        mockCars.add(new Car(17L, "Mobi", "Fiat", "Amarelo", 2023, 
        70000.00, 150, 0));
    }
    
    @Test
    public void shouldListAllCarsInGetRequest() throws Exception{

        when(carServiceMock.getAll()).thenReturn(mockCars);

        mockMvc.perform(get("/carros"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON));

        verify(carServiceMock).getAll();
    }
}

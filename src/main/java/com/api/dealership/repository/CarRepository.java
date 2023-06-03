package com.api.dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.dealership.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}

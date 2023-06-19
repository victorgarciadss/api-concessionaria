package com.api.dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dealership.entity.Sale;
import com.api.dealership.entity.SalePK;

public interface SaleRepository extends JpaRepository<Sale, SalePK> {
    
}

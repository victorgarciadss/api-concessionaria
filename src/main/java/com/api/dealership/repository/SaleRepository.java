package com.api.dealership.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.dealership.entity.Sale;
import com.api.dealership.entity.SalePK;
import com.api.dealership.projections.SoldCarProjection;

public interface SaleRepository extends JpaRepository<Sale, SalePK> {

    @Query(value = """
        SELECT
        clients.client_name AS clientName,
        cars.model_name AS carName,
        cars.brand AS carBrand,
        sales.value AS saleValue,
        sales.sale_date AS saleDate
        FROM sales
        INNER JOIN clients
            ON sales.client_id = clients.id
        INNER JOIN cars
            ON sales.car_id = cars.id
                    """,
         nativeQuery = true)
    public List<SoldCarProjection> findAllSales();
}

package com.api.dealership.dto;

public class SaleDto {
    
    private Long carId;
    private Long buyerId;

    public SaleDto() {

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    

    
}

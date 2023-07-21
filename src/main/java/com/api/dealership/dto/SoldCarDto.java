package com.api.dealership.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.api.dealership.projections.SoldCarProjection;

public class SoldCarDto {
    
    private String clientName;
    private String carName;
    private String carBrand;
    private BigDecimal saleValue;
    private LocalDateTime saleDate;
    
    
    public SoldCarDto(String clientName, String carName, String carBrand, BigDecimal saleValue,
            LocalDateTime saleDate) {
        this.clientName = clientName;
        this.carName = carName;
        this.carBrand = carBrand;
        this.saleValue = saleValue;
        this.saleDate = saleDate;
    }

    public SoldCarDto(SoldCarProjection projection){
        this.clientName = projection.getClientName();
        this.carName = projection.getCarName();
        this.carBrand = projection.getCarBrand();
        this.saleValue = projection.getSaleValue();
        this.saleDate = projection.getSaleDate();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
        result = prime * result + ((carName == null) ? 0 : carName.hashCode());
        result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
        result = prime * result + ((saleValue == null) ? 0 : saleValue.hashCode());
        result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SoldCarDto other = (SoldCarDto) obj;
        if (clientName == null) {
            if (other.clientName != null)
                return false;
        } else if (!clientName.equals(other.clientName))
            return false;
        if (carName == null) {
            if (other.carName != null)
                return false;
        } else if (!carName.equals(other.carName))
            return false;
        if (carBrand == null) {
            if (other.carBrand != null)
                return false;
        } else if (!carBrand.equals(other.carBrand))
            return false;
        if (saleValue == null) {
            if (other.saleValue != null)
                return false;
        } else if (!saleValue.equals(other.saleValue))
            return false;
        if (saleDate == null) {
            if (other.saleDate != null)
                return false;
        } else if (!saleDate.equals(other.saleDate))
            return false;
        return true;
    }

    

    
}

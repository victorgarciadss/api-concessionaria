package com.api.dealership.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SalePK {
    
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Long carId;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Long clientId;

    public SalePK() {
        
    }

    public SalePK(Long carId, Long clientId) {
        this.carId = carId;
        this.clientId = clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getClienIdt() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carId == null) ? 0 : carId.hashCode());
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        
        SalePK other = (SalePK) obj;
        if (carId == null || other.carId != null){
            return false;
        } 
        if (clientId == null || other.clientId != null) {
            return false;
        }
        if (carId.equals(other.carId) && clientId.equals(other.clientId)){
            return true;
        }
            
        return false;
    }

    

    

    
}

package com.api.dealership.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SalePK {
    
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public SalePK() {
        
    }

    public SalePK(Car carId, Client clientId) {
        this.car = carId;
        this.client = clientId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        
        SalePK other = (SalePK) obj;
        if (car == null || other.car != null){
            return false;
        } 
        if (client == null || other.client != null) {
            return false;
        }
        if (car.equals(other.car) && client.equals(other.client)){
            return true;
        }
            
        return false;
    }

    

    

    
}

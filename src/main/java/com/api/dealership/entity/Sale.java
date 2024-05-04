package com.api.dealership.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {
    
    @EmbeddedId
    private SalePK id = new SalePK();

    private Date saleDate;
    private Double value;

    public Sale() {

    }
    
    public Sale(Car car, Client client){
        this.id.setCar(car);
        this.id.setClient(client);
    }

    public Sale(Car car, Client client, Date saleDate, Double value) {
        this.id.setCar(car);
        this.id.setClient(client);
        this.saleDate = saleDate;
        this.value = value;
    }

    public SalePK getId() {
        return id;
    }

    public void setId(SalePK id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id) && Objects.equals(saleDate, sale.saleDate) && Objects.equals(value, sale.value);
    }
}

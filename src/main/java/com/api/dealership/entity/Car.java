package com.api.dealership.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String brand;
    private String color;
    private Integer launchYear;
    private Double price;
    private Integer potency;
    private Integer soldAmount;

    public Car() {

    }

    public Car(
        Long id, String modelName, String brand, String color,
        Integer launchYear, Double price, Integer potency, Integer soldAmount
    ) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.color = color;
        this.launchYear = launchYear;
        this.price = price;
        this.potency = potency;
        this.soldAmount = soldAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(Integer launchYear) {
        this.launchYear = launchYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPotency() {
        return potency;
    }

    public void setPotency(Integer potency) {
        this.potency = potency;
    }

    public Integer getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(Integer soldAmount) {
        this.soldAmount = soldAmount;
    }

    @Override
    public String toString() {
        return "Carro [id = " + id + ", nome do Modelo = " + modelName + ", marca = " + brand + ", cor ="
         + color + ", ano de lançamento = " + launchYear + ", preço = " + price + ", potência = " + potency
         + ", quantidade vendida = " + soldAmount + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Car other = (Car) obj;
        if (this.id == null || other.id != null) {
                return false;
        } if (id.equals(other.id)){
            return true;
        }
        return false;
    }

    

    

    

    

}

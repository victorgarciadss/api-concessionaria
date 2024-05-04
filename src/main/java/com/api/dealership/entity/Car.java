package com.api.dealership.entity;

import org.springframework.beans.BeanUtils;

import com.api.dealership.dto.CarDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String brand;
    private String color;
    private String carImage;
    private Integer launchYear;
    private Double price;
    private Integer potency;
    private Integer soldAmount = 0;

    public Car() {

    }

    public Car(CarDto carDto){
        BeanUtils.copyProperties(carDto, this);;
    }

    public Car(
        Long id, String modelName, String brand, String color, String carImage,
        Integer launchYear, Double price, Integer potency, Integer soldAmount
    ) {
        this.id = id;
        this.modelName = modelName;
        this.brand = brand;
        this.color = color;
        this.carImage = carImage;
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

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
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
        return "Car{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", carImage='" + carImage + '\'' +
                ", launchYear=" + launchYear +
                ", price=" + price +
                ", potency=" + potency +
                ", soldAmount=" + soldAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(modelName, car.modelName) && Objects.equals(brand, car.brand) && Objects.equals(color, car.color) && Objects.equals(carImage, car.carImage) && Objects.equals(launchYear, car.launchYear) && Objects.equals(price, car.price) && Objects.equals(potency, car.potency) && Objects.equals(soldAmount, car.soldAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, brand, color, carImage, launchYear, price, potency, soldAmount);
    }
}

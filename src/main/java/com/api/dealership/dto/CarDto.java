package com.api.dealership.dto;

import org.springframework.beans.BeanUtils;

import com.api.dealership.entity.Car;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarDto {
    
    @NotBlank(message = "Insira um modelo válido")
    private String modelName;

    @NotBlank(message = "Insira a marca corretamente")
    private String brand;
    
    private String color;

    @NotNull(message = "O campo de ano não pode ser nulo")
    @Min(value = 1800, message = "O ano minimo aceitavel eh 1800")
    private Integer launchYear;

    @DecimalMin(value = "1000", message = "O valor mínimo do carro deve ser 1000 Reais")
    private Double price;

    private Integer potency;
    

    public CarDto() {

    }

    public CarDto(
        String modelName, String brand, String color, Integer launchYear, Double price, Integer potency
    ){
        this.modelName = modelName;
        this.brand = brand;
        this.color = color;
        this.launchYear = launchYear;
        this.price = price;
        this.potency = potency;
    }



    public CarDto(Car entity){
        BeanUtils.copyProperties(entity, this);
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


    

    


}

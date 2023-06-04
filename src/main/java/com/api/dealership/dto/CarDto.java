package com.api.dealership.dto;

import org.springframework.beans.BeanUtils;

import com.api.dealership.entity.Car;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

public class CarDto {
    
    @NotBlank(message = "Insira um modelo válido")
    private String modelName;

    @NotBlank(message = "Insira a marca corretamente")
    private String brand;
    
    private String color;

    @NotBlank(message = "Insira um ano")
    @Digits(integer = 4, fraction = 0, message = "O Ano digitado deve ter 4 digitos")
    private Integer launchYear;

    @DecimalMin(value = "1000", message = "O valor mínimo do carro deve ser 1000 Reais")
    private Double price;

    private Integer potency;
    

    public CarDto() {

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

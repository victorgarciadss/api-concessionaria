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

    private String carImage;

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

    public CarDto(String modelName, String brand, String color, String carImage, Integer launchYear, Double price, Integer potency) {
        this.modelName = modelName;
        this.brand = brand;
        this.color = color;
        this.carImage = carImage;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((launchYear == null) ? 0 : launchYear.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((potency == null) ? 0 : potency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }  
            
        CarDto other = (CarDto) obj;

        if (modelName == null && other.modelName != null || !modelName.equals(other.modelName)) {
            return false;
        }
        if (brand == null && other.brand != null || !brand.equals(other.brand)) {
            return false;
        }
        if (color == null && other.color != null || !color.equals(other.color)) {
            return false;
        }
        if (launchYear == null && other.launchYear != null || !launchYear.equals(other.launchYear)) {
            return false;
        }
        if (price == null && other.price != null || !price.equals(other.price)) {
            return false;
        }
        if (potency == null && other.potency != null || !potency.equals(other.potency)) {
            return false;
        }

        return true;
    }


}

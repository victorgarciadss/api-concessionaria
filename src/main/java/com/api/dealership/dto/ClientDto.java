package com.api.dealership.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDto {
    
    @NotBlank(message = "Insira um nome valido")
    private String name;

    @Size(min = 11, max = 11, message = "Deve haver exatamente 11 carateres")
    private String cpf;

    @NotBlank(message = "Insira um endereco valido")
    private String adress;

    @Min(value = 18, message = "A idade minima para cadastro eh 18 anos")
    private Integer age;

    public ClientDto() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    
}

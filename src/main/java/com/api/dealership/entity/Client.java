package com.api.dealership.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    private String cpf;
    private String adress;
    private Integer age;
    
    public Client() {

    }

    public Client(Long id, String name, String cpf, String adress, Integer age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.adress = adress;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cliente [id = " + id + ", nome = " + name + ", cpf = " + cpf + ", endereço = " + adress
         + ", idade = " + age + "]";
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
            
        Client other = (Client) obj;

        if (id == null || other.id == null) {
            return false;
        }
        if (this.id.equals(other.id)){
            return true;
        }
        
        return false;
    }

    

    

    

    
}

package com.api.dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.dealership.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}

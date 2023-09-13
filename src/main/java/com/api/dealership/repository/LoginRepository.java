package com.api.dealership.repository;

import com.api.dealership.entity.logins.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<Login, Long> {
    public UserDetails findByUserName(String userName);
}

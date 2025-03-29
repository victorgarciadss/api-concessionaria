package com.api.dealership.dto;

import com.api.dealership.entity.logins.LoginRole;

public record EmployeeDto(Long id, String username, LoginRole role) {
}

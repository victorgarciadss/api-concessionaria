package com.api.dealership.dto;

import com.api.dealership.entity.logins.LoginRole;

public record RegisterDto(String userName, String password, LoginRole role) {
}

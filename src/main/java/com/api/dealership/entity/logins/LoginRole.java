package com.api.dealership.entity.logins;

public enum LoginRole {

    ADMIN("admin"),
    EMPLOYEE("employee");

    private String role;

    LoginRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

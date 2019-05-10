package com.example.login.service;

public class StringService {
    public static boolean isEmail(String email){
        String format = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
        return email.matches(format);
    }

    public static boolean isValidPassword(String password) {
        String format = "^[a-zA-Z0-9]$";
        return password.matches(format);
    }
}

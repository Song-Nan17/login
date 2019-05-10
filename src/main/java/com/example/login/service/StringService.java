package com.example.login.service;

public class StringService {
    public static boolean isEmail(String email){
        String format = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
        return email.matches(format);
    }
}

package com.example.login.service;

public class StringService {
    public static boolean isEmail(String email) {
        String format = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
        return email.matches(format);
    }

    public static boolean isValidPassword(String password) {
        String letters = "^.*[a-zA-Z].*$";
        String numbers = "^.*[0-9].*$";
        String specialCharacter = "^[^/@#/$%/^&/*]*[/@#/$%/^&/*][^/@#/$%/^&/*]*$";
        return password.matches(letters) &&
                password.matches(numbers) &&
                password.matches(specialCharacter) &&
                password.length() >= 8;
    }
}

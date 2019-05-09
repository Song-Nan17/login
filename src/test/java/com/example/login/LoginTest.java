package com.example.login;

import org.junit.Test;

public class LoginTest {

    @Test
    public void should_enter_username_password_and_confirm_password() {
        String username = "nujabes";
        String password = "Luvsic13";
        String confirmPassword = "Luvsic13";
        Login.login(username,password,confirmPassword);
    }
}

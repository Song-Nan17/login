package com.example.login;

public class Login {
    public static void login(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("用户名和密码不能为空！");
        }
    }
}

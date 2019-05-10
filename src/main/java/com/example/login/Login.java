package com.example.login;

import com.example.login.service.StringService;

public class Login {
    public static void login(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("用户名和密码不能为空！");
        }else if (!StringService.isEmail(username)) {
            System.out.println("用户名必须为有效的邮箱地址！");
        }
    }
}

package com.example.login;

import com.example.login.service.StringService;

public class Login {
    public static void login(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("用户名和密码不能为空！");
        } else if (!StringService.isEmail(username)) {
            System.out.println("用户名必须为有效的邮箱地址！");
        } else if (!StringService.isValidPassword(password)) {
            System.out.println("密码必须包含子母和数字，长度不小于8为，且必须含有仅一位特殊字符（@#$%^&*）！");
        } else if (!password.equals(confirmPassword)) {
            System.out.println("确认密码不一致！请重新输入。");
        } else {
            System.out.println("恭喜您注册成功！");
        }
    }
}

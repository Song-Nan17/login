package com.example.login;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void should_enter_username_password_and_confirm_password() {
        String username = "nujabes";
        String password = "Luvsic13";
        String confirmPassword = "Luvsic13";
        Login.login(username, password, confirmPassword);
    }

    @Test
    public void should_give_hint_when_username_or_password_is_empty() {
        String emptyString = "";
        String username = "nujabes";
        String password = "Luvsic13";
        String confirmPassword = "Luvsic13";

        String hint = "用户名和密码不能为空！\n";

        Login.login(emptyString, emptyString, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
        log.clearLog();

        Login.login(emptyString, password, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
        log.clearLog();

        Login.login(username, emptyString, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }

    @Test
    public void should_give_hint_when_username_is_not_email() {
        String email = "nujabes@qq.com";
        String notEmail = "nujabes";
        String password = "Luvsic13";
        String confirmPassword = "Luvsic13";

        String hint = "用户名必须为有效的邮箱地址！\n";

        Login.login(email, password, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), not(hint));
        log.clearLog();

        Login.login(notEmail, password, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }
}

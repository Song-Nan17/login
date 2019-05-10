package com.example.login;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class LoginTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    private String username = "nujabes@qq.com";
    private String password = "Luvsic&13";
    private String confirmPassword = "Luvsic&13";

    @Test
    public void should_enter_username_password_and_confirm_password() {
        Login.login(username, password, confirmPassword);
    }

    @Test
    public void should_give_hint_when_username_or_password_is_empty() {
        String emptyString = "";

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
        String notEmail = "nujabes";

        String hint = "用户名必须为有效的邮箱地址！\n";

        Login.login(username, password, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), not(hint));
        log.clearLog();

        Login.login(notEmail, password, confirmPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }

    @Test
    public void should_give_hint_when_password_not_contains_letter_and_number() {
        String numbers = "1111111";
        String letters = "aaaaaaa";

        String hint = "密码必须包含子母和数字，长度不小于8为，且必须含有一位特殊字符（@#$%^&*）！\n";

        Login.login(username, numbers, numbers);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
        log.clearLog();

        Login.login(username, letters, letters);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }

    @Test
    public void should_give_hint_when_password_shorter_than_8() {
        String shortPassword = "aB123";

        String hint = "密码必须包含子母和数字，长度不小于8为，且必须含有一位特殊字符（@#$%^&*）！\n";

        Login.login(username, shortPassword, shortPassword);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }

    @Test
    public void should_give_hint_when_special_character_in_password_is_not_one() {
        String noSpecialCharacter = "a12345678";
        String twoSpecialCharacter = "a&sd$*12345";

        String hint = "密码必须包含子母和数字，长度不小于8为，且必须含有一位特殊字符（@#$%^&*）！\n";

        Login.login(username, noSpecialCharacter, noSpecialCharacter);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
        log.clearLog();

        Login.login(username, twoSpecialCharacter, twoSpecialCharacter);
        assertThat(log.getLogWithNormalizedLineSeparator(), is(hint));
    }
}

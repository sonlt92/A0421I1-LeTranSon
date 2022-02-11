package com.letranson.furama;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Pass {
    public static void main(String[] args) {
        String pass = new BCryptPasswordEncoder().encode("123456");
        System.out.println(pass);
    }
}

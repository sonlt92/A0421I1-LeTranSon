package com.letranson.muonsach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MuonSachApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuonSachApplication.class, args);
    }

}

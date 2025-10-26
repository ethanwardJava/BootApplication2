package com.arcade.bootapplication2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BootApplication2Application {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication2Application.class, args);
    }

}

package com.hj.jdpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.hj.jdpt.repository")
@SpringBootApplication
public class JdptApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdptApplication.class, args);
    }

}

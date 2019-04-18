package com.graduationproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.graduationproject.dao")
public class DeclarationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeclarationApplication.class, args);
        System.out.println("===============");
    }

}

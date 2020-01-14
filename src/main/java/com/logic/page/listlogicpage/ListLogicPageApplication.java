package com.logic.page.listlogicpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.logic.page.listlogicpage.mapper")
public class ListLogicPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListLogicPageApplication.class, args);
    }

}

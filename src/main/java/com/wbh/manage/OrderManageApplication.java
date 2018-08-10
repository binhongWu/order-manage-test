package com.wbh.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wbh.manage.mapper")
public class OrderManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManageApplication.class, args);
	}
}

package com.chemi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class ChemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChemiApplication.class, args);
	}

}

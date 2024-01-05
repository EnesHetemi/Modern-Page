package com.modern.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.modern.common.entity", "com.modern.admin.user"})
public class ModernBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernBackEndApplication.class, args);
	}

}

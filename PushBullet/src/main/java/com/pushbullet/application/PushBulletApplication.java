package com.pushbullet.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pushbullet.*")
public class PushBulletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushBulletApplication.class, args);
	}

}

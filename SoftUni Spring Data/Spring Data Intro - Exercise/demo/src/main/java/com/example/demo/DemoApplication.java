package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		final long ddz= new Random().nextLong(1,50);
		SpringApplication.run(DemoApplication.class, args);
	}
}

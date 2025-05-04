package com.example.FirstJenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/jenkins")
public class FirstJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJenkinsApplication.class, args);


	}

	@GetMapping
	public ResponseEntity<String> getJenkins(){
		return ResponseEntity.ok("I am from Jenkins");
	}

}

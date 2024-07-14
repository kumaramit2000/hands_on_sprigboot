package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@GetMapping
	public List<Student> hello(){
		Student s1 = new Student(100L,"Amit","amit.kumar@gmail.com", LocalDate.of(2000,01,02), 24);
		Student s2 = new Student(201L,"Lalit","lalit.kumar@gmail.com", LocalDate.of(2002,07,12), 22);

		return List.of(s1,s2);
	}
}

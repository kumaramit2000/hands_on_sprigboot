package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student s1 = new Student("Amit","amit.kumar@gmail.com", LocalDate.of(2000,01,02), 24);
            Student s2 = new Student("Lalit","lalit.kumar@gmail.com", LocalDate.of(2002,07,12), 22);
            repository.saveAll(List.of(s1,s2));
        };
    }
}

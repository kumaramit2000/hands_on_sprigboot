package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
//        Student s1 = new Student(100L,"Amit","amit.kumar@gmail.com", LocalDate.of(2000,01,02), 24);
//        Student s2 = new Student(201L,"Lalit","lalit.kumar@gmail.com", LocalDate.of(2002,07,12), 22);

//        return List.of(s1,s2);

        return studentRepository.findAll();
    }
}

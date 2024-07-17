package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student){

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
//        System.out.println("student - already present in database." );
        if(!studentByEmail.isPresent()){
            studentRepository.save(student);
        } else {
            System.out.println("student - "+ student.getName() +" already present in database." );
        }
    }

    public void deleteStudent(Long id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        } else {
            System.out.println("Student Is Not Present In The Database.");
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student studentById = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Studnet with id " + id + "does not exist"));

        if(email != null && !email.isEmpty()){
            studentById.setEmail(email);
        }

        if(name != null && !name.isEmpty()){
            studentById.setName(name);
        }
    }
}

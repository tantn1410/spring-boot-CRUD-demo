package com.example.demo.controller;

import com.example.demo.exception.*;
import com.example.demo.model.student.Student;
import com.example.demo.model.student.UpdateStudent;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public List<Student> getListStudent() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return Collections.emptyList();
    }

    @PostMapping("/new")
    public Student createStudent(@RequestBody @Valid Student newStudent) {
        try {
            return studentRepository.save(newStudent);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return null;
    }

    @GetMapping("/detail/{id}")
    public Student getStudentById(@PathVariable String id) {
        try {
            return studentRepository.findById(Integer.parseInt(id))
                    .orElseThrow(() -> new IdNotFoundException(Integer.parseInt(id)));
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public Student updateStudentById(@PathVariable String id, @Valid @RequestBody UpdateStudent updateBody) {
        try {
            Student updatedStudent = studentRepository.findById(Integer.parseInt(id))
                    .orElseThrow(() -> new IdNotFoundException(Integer.parseInt(id)));

            updatedStudent.setName(updateBody.getName());
            updatedStudent.setAge(updateBody.getAge());
            updatedStudent.setMajor(updateBody.getMajor());
            updatedStudent.setSelfIntroduction(updateBody.getSelfIntroduction());
            updatedStudent.setCpa(updateBody.getCpa());

            return studentRepository.save(updatedStudent);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id) {
        try {
            Student deletedStudent = studentRepository.findById(Integer.parseInt(id))
                    .orElseThrow(() -> new IdNotFoundException(Integer.parseInt(id)));

            studentRepository.delete(deletedStudent);

            return ResponseEntity.ok("Deleted student with id = " + id);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

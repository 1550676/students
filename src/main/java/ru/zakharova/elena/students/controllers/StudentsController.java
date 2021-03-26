package ru.zakharova.elena.students.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.zakharova.elena.students.model.Student;
import ru.zakharova.elena.students.service.StudentService;

import java.util.List;

@RestController
@CrossOrigin()
@AllArgsConstructor
@RequestMapping("/students")
public class StudentsController {
    private StudentService studentService;


    @GetMapping(produces = "application/json")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//    @GetMapping(produces = "application/json")
//    public List<Product> getAllProducts() {
//        return productsService.findAll();
//    }
//
    @GetMapping(value = "/{id}", produces = "application/json")
    public Student getOneProduct(@PathVariable Long id) {
       return studentService.getById(id).get();
    }




    @DeleteMapping("/{id}")
    public void deleteOneProducts(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Student saveNewStudent(@RequestBody Student student) {
        if (student.getId() != null) {
            student.setId(null);
        }
        return studentService.saveOrUpdate(student);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Student modifyStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }
}
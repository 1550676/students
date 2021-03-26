package ru.zakharova.elena.students.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @GetMapping(value = "/{id}", produces = "application/json")
//    @ApiOperation("Returns one product by id")
////    @ApiImplicitParams(value = {
////            @ApiImplicitParam(name = "demo", type = "String", required = false, paramType = "query")
////    })
//    public ResponseEntity<?> getOneProduct(@PathVariable @ApiParam("Id of the product to be requested. Cannot be empty") Long id) {
//        if (!productsService.existsById(id)) {
//            throw new ProductNotFoundException("Product not found, id: " + id);
//        }
//        return new ResponseEntity<>(productsService.findById(id), HttpStatus.OK);
//    }
//


    @DeleteMapping("/{id}")
    public void deleteOneProducts(@PathVariable Long id) {
        studentService.deleteById(id);
    }
//
//    @PostMapping(consumes = "application/json", produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation("Creates a new product")
//    public Product saveNewProduct(@RequestBody Product product) {
//        if (product.getId() != null) {
//            product.setId(null);
//        }
//        return productsService.saveOrUpdate(product);
//    }
//
//    @PutMapping(consumes = "application/json", produces = "application/json")
//    @ApiOperation("Modifies an existing product")
//    public ResponseEntity<?> modifyProduct(@RequestBody Product product) {
//        if (product.getId() == null || !productsService.existsById(product.getId())) {
//            throw new ProductNotFoundException("Product not found, id: " + product.getId());
//        }
//        if (product.getPrice().doubleValue() < 0.0) {
//            return new ResponseEntity<>("Product's price can not be negative", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(productsService.saveOrUpdate(product), HttpStatus.OK);
//    }
}
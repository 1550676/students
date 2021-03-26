package ru.zakharova.elena.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharova.elena.students.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllById(Long id);

}

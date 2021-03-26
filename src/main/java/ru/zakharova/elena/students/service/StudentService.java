package ru.zakharova.elena.students.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zakharova.elena.students.model.Student;
import ru.zakharova.elena.students.repository.StudentRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setRolesRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional
    public void update(Student student) {
        Student original = studentRepository.getOne(student.getId());

    }


    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}

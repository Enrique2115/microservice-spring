package com.microservice.student.domain.port.out;

import com.microservice.student.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryPort {

    void createStudent(Student student);

    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> findByIdCourse(Long idCourse);
}

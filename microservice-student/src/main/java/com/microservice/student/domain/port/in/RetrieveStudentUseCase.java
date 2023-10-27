package com.microservice.student.domain.port.in;

import com.microservice.student.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface RetrieveStudentUseCase {

    List<Student> findAllStudents();

    Optional<Student> findById(Long id);

    List<Student> findByIdCourse(Long idCourse);

}

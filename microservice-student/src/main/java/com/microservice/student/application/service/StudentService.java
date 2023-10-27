package com.microservice.student.application.service;

import com.microservice.student.domain.models.Student;
import com.microservice.student.domain.port.in.CreateStudentUseCase;
import com.microservice.student.domain.port.in.RetrieveStudentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements CreateStudentUseCase, RetrieveStudentUseCase {
    private final CreateStudentUseCase createStudentUseCase;
    private final RetrieveStudentUseCase retrieveStudentUseCase;

    @Autowired
    public StudentService(
            @Qualifier("createStudentUseCaseImpl") CreateStudentUseCase createStudentUseCase,
            @Qualifier("retrieveStudentUseCaseImpl") RetrieveStudentUseCase retrieveStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.retrieveStudentUseCase = retrieveStudentUseCase;
    }

    @Override
    public void createStudent(Student student) {
        createStudentUseCase.createStudent(student);
    }


    @Override
    public List<Student> findAllStudents() {
        return retrieveStudentUseCase.findAllStudents();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return retrieveStudentUseCase.findById(id);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return retrieveStudentUseCase.findByIdCourse(idCourse);
    }
}

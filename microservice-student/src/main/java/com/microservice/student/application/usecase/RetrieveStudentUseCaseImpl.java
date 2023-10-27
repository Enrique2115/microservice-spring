package com.microservice.student.application.usecase;

import com.microservice.student.domain.models.Student;
import com.microservice.student.domain.port.in.RetrieveStudentUseCase;
import com.microservice.student.domain.port.out.StudentRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RetrieveStudentUseCaseImpl implements RetrieveStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;

    @Autowired
    public RetrieveStudentUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepositoryPort.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepositoryPort.findById(id);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepositoryPort.findByIdCourse(idCourse);
    }
}

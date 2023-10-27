package com.microservice.student.application.usecase;

import com.microservice.student.domain.models.Student;
import com.microservice.student.domain.port.in.CreateStudentUseCase;
import com.microservice.student.domain.port.out.StudentRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {
    private final StudentRepositoryPort studentRepositoryPort;

    @Autowired
    public CreateStudentUseCaseImpl(StudentRepositoryPort studentRepositoryPort) {
        this.studentRepositoryPort = studentRepositoryPort;
    }

    @Override
    public void createStudent(Student student) {
        studentRepositoryPort.createStudent(student);
    }
}

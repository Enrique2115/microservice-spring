package com.microservice.student.domain.port.in;

import com.microservice.student.domain.models.Student;

public interface CreateStudentUseCase {

    void createStudent(Student student);
}

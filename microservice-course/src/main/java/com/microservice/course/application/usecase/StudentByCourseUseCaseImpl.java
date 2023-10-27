package com.microservice.course.application.usecase;

import com.microservice.course.domain.port.in.StudentByCourseUseCase;
import com.microservice.course.domain.port.out.CourseRepositoryPort;
import com.microservice.course.infraestructure.http.response.StudentByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentByCourseUseCaseImpl implements StudentByCourseUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    @Autowired
    public StudentByCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort){
        this.courseRepositoryPort = courseRepositoryPort;
    }
    @Override
    public StudentByCourseResponse findByStudentsByCourse(Long idCourse) {
        return courseRepositoryPort.findByStudentsByCourse(idCourse);
    }
}

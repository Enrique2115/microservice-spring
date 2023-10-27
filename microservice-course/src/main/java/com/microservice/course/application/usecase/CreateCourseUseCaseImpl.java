package com.microservice.course.application.usecase;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.in.CreateCourseUseCase;
import com.microservice.course.domain.port.out.CourseRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseRepositoryPort courseRepositoryPort;

    @Autowired
    public CreateCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort){
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public void createCourse(Course course) {
        courseRepositoryPort.createCourse(course);
    }
}

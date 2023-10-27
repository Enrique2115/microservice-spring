package com.microservice.course.application.services;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.in.CreateCourseUseCase;
import com.microservice.course.domain.port.in.RetrieveCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CreateCourseUseCase, RetrieveCourseUseCase {

    private final CreateCourseUseCase createCourseUseCase;
    private final RetrieveCourseUseCase retrieveCourseUseCase;

    @Autowired
    public CourseService(
            @Qualifier("createCourseUseCaseImpl") CreateCourseUseCase createCourseUseCase,
            @Qualifier("retrieveCourseUseCaseImpl") RetrieveCourseUseCase retrieveCourseUseCase
    ){
        this.createCourseUseCase = createCourseUseCase;
        this.retrieveCourseUseCase = retrieveCourseUseCase;
    }

    @Override
    public void createCourse(Course course) {
        createCourseUseCase.createCourse(course);
    }

    @Override
    public List<Course> findAll() {
        return retrieveCourseUseCase.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return retrieveCourseUseCase.findById(id);
    }
}

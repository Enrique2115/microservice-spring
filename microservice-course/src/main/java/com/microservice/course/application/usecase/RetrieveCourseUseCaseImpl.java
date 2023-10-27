package com.microservice.course.application.usecase;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.in.RetrieveCourseUseCase;
import com.microservice.course.domain.port.out.CourseRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RetrieveCourseUseCaseImpl implements RetrieveCourseUseCase {
    private final CourseRepositoryPort courseRepositoryPort;

    @Autowired
    public RetrieveCourseUseCaseImpl(CourseRepositoryPort courseRepositoryPort) {
        this.courseRepositoryPort = courseRepositoryPort;
    }

    @Override
    public List<Course> findAll() {
        return courseRepositoryPort.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepositoryPort.findById(id);
    }
}

package com.microservice.course.domain.port.in;

import com.microservice.course.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface RetrieveCourseUseCase {

    List<Course> findAll();

    Optional<Course> findById(Long id);

}

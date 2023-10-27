package com.microservice.course.domain.port.in;

import com.microservice.course.domain.models.Course;

public interface CreateCourseUseCase {

    void createCourse(Course course);
}

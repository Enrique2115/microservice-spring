package com.microservice.course.domain.port.out;

import com.microservice.course.domain.models.Course;
import com.microservice.course.infraestructure.http.response.StudentByCourseResponse;

import java.util.List;
import java.util.Optional;

public interface CourseRepositoryPort {

    void createCourse(Course course);

    List<Course> findAll();

    Optional<Course> findById(Long id);

    StudentByCourseResponse findByStudentsByCourse(Long idCourse);
}

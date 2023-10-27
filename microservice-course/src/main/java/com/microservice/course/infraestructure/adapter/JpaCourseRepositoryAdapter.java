package com.microservice.course.infraestructure.adapter;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.out.CourseRepositoryPort;
import com.microservice.course.infraestructure.repository.CoursePersistence;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final CoursePersistence coursePersistence;

    public JpaCourseRepositoryAdapter(CoursePersistence coursePersistence) {
        this.coursePersistence = coursePersistence;
    }

    @Override

    public void createCourse(Course course) {
        coursePersistence.save(course);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) coursePersistence.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return coursePersistence.findById(id);
    }
}

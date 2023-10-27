package com.microservice.course.infraestructure.repository;

import com.microservice.course.domain.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePersistence extends CrudRepository<Course, Long> {
}

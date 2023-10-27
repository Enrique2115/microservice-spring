package com.microservice.student.infraestructure.repository;

import com.microservice.student.domain.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPersistance extends CrudRepository<Student, Long> {

    List<Student> findAllByCourseId(Long courseId);
}

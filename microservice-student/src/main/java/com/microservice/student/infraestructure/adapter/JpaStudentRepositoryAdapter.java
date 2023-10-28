package com.microservice.student.infraestructure.adapter;

import com.microservice.student.domain.models.Student;
import com.microservice.student.domain.port.out.StudentRepositoryPort;
import com.microservice.student.infraestructure.repository.StudentPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaStudentRepositoryAdapter implements StudentRepositoryPort {
    private final StudentPersistance studentPersistance;

    @Autowired
    public JpaStudentRepositoryAdapter(StudentPersistance studentPersistance) {
        this.studentPersistance = studentPersistance;
    }

    @Override
    public void createStudent(Student student) {
        studentPersistance.save(student);
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentPersistance.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentPersistance.findById(id);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentPersistance.findAllByCourseId(idCourse);
    }
}

package com.microservice.course.application.services;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.in.CreateCourseUseCase;
import com.microservice.course.domain.port.in.RetrieveCourseUseCase;
import com.microservice.course.domain.port.in.StudentByCourseUseCase;
import com.microservice.course.infraestructure.http.response.StudentByCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CreateCourseUseCase, RetrieveCourseUseCase, StudentByCourseUseCase {

    private final CreateCourseUseCase createCourseUseCase;
    private final RetrieveCourseUseCase retrieveCourseUseCase;

    private final StudentByCourseUseCase studentByCourseUseCase;

    @Autowired

    public CourseService(
            @Qualifier("createCourseUseCaseImpl") CreateCourseUseCase createCourseUseCase,
            @Qualifier("retrieveCourseUseCaseImpl") RetrieveCourseUseCase retrieveCourseUseCase,
            @Qualifier("studentByCourseUseCaseImpl") StudentByCourseUseCase studentByCourseUseCase
    ) {
        this.createCourseUseCase = createCourseUseCase;
        this.retrieveCourseUseCase = retrieveCourseUseCase;
        this.studentByCourseUseCase = studentByCourseUseCase;
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

    @Override
    public StudentByCourseResponse findByStudentsByCourse(Long idCourse) {
        return studentByCourseUseCase.findByStudentsByCourse(idCourse);
    }
}

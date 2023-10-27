package com.microservice.course.domain.port.in;

import com.microservice.course.infraestructure.http.response.StudentByCourseResponse;

public interface StudentByCourseUseCase {
    StudentByCourseResponse findByStudentsByCourse(Long idCourse);

}

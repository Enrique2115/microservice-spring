package com.microservice.course.infraestructure.adapter;

import com.microservice.course.domain.models.Course;
import com.microservice.course.domain.port.out.CourseRepositoryPort;
import com.microservice.course.infraestructure.client.StudentClient;
import com.microservice.course.infraestructure.dto.StudentDTO;
import com.microservice.course.infraestructure.http.response.StudentByCourseResponse;
import com.microservice.course.infraestructure.repository.CoursePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCourseRepositoryAdapter implements CourseRepositoryPort {

    private final CoursePersistence coursePersistence;

    private final StudentClient studentClient;

    @Autowired
    public JpaCourseRepositoryAdapter(
            CoursePersistence coursePersistence,
            StudentClient studentClient
    ) {
        this.coursePersistence = coursePersistence;
        this.studentClient = studentClient;
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
        if (id == null || id.equals(0L)) {
            // handle validation for null or empty id
            return Optional.empty();
        }

        return coursePersistence.findById(id);
    }

    @Override
    public StudentByCourseResponse findByStudentsByCourse(Long idCourse) {
        // Consultar el curse
        Course course = coursePersistence.findById(idCourse).orElse(new Course());

        // Consultar los estudiantes al microservice de estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        // Retornar los datos
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentsDTOList(studentDTOList)
                .build();
    }
}

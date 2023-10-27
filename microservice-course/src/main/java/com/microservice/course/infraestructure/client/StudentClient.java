package com.microservice.course.infraestructure.client;

import com.microservice.course.infraestructure.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student", url = "localhost:8090/api/v1/student")
public interface StudentClient {

    @GetMapping("/course/{id}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long id);
}

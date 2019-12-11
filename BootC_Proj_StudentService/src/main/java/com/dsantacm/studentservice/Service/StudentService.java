package com.dsantacm.studentservice.Service;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

// import com.dsantacm.studentservice.DataAccess.StudentRepository;
// import com.dsantacm.studentservice.Model.Student;

// import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;

//public class StudentService {
//     private StudentRepository studentRepository;

//     public Mono<Student> findByDni(String dni) {
//         return studentRepository
//             .findByDni(dni)
//             .flatMap(p -> p.get);
//     }
//}
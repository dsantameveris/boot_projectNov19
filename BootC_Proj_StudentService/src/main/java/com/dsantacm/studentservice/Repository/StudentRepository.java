package com.dsantacm.studentservice.Repository;

import com.dsantacm.studentservice.Model.Student;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//StudentService DAO es la clase que maneja el acceso a la DB de estudiantes. Utiliza ReactiveMongo por que se esta diseñando todo reactivo.
public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
}
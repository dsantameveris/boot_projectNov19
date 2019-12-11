package com.dsantacm.familyservice.Repository;

import com.dsantacm.familyservice.Model.Relative;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//StudentService DAO es la clase que maneja el acceso a la DB de estudiantes. Utiliza ReactiveMongo por que se esta diseñando todo reactivo.
public interface FamilyRepository extends ReactiveMongoRepository<Relative, String> {
}
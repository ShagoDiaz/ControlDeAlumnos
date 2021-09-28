package com.edutecno.controlalumnos.repository​;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.controlalumnos.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}

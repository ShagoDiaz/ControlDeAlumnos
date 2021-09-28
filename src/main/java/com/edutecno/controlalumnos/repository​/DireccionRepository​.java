package com.edutecno.controlalumnos.repository​;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.controlalumnos.entity.Direccion;

@Repository
public interface DireccionRepository​ extends CrudRepository<Direccion, Integer> {

}

package com.edutecno.controlalumnos.service;

import com.edutecno.controlalumnos.dto.AlumnoDto;
import com.edutecno.controlalumnos.entity.Alumno;

public interface AlumnoService​ {

	public AlumnoDto save(Alumno alumno);

	public AlumnoDto findAll();
}

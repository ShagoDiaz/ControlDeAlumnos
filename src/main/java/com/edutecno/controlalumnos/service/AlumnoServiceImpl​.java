package com.edutecno.controlalumnos.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.controlalumnos.ControlDeAlumnosApplication;
import com.edutecno.controlalumnos.dto.AlumnoDto;
import com.edutecno.controlalumnos.entity.Alumno;
import com.edutecno.controlalumnos.repository​.AlumnoRepository;

import lombok.Data;

@Service
public class AlumnoServiceImpl​ implements AlumnoService​ {

	private static final Logger log = LoggerFactory.getLogger(ControlDeAlumnosApplication.class);

	@Autowired
	private AlumnoRepository repository;
	private AlumnoDto respuesta;

	@Override
	public AlumnoDto save(Alumno alumno) {
		respuesta = new AlumnoDto("Error intentando guardar en la BD", "100", new ArrayList<Alumno>());
		try {
			respuesta.getListadoAlumnos().add(repository.save(alumno));
			respuesta.setCodigo("000");
			respuesta.setMensaje("Alumno registrado correctamente");
		} catch (Exception e) {
			log.error("AlumnoService -> save : Error " + e);
		}
		return respuesta;

	}

	@Override
	public AlumnoDto findAll() {
		respuesta = new AlumnoDto("Error intentando leer desde la BD", "100", new ArrayList<Alumno>());
		try {
			respuesta.setListadoAlumnos((List<Alumno>) repository.findAll());
			respuesta.setCodigo("000");
			respuesta.setMensaje("Alumnos cargados correctamente");
		} catch (Exception e) {
			log.error("AlumnoService -> findAll : Error " + e);
		}

		return respuesta;
	}

}

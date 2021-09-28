package com.edutecno.controlalumnos.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.controlalumnos.ControlDeAlumnosApplication;
import com.edutecno.controlalumnos.dto.DireccionDto;
import com.edutecno.controlalumnos.entity.Direccion;
import com.edutecno.controlalumnos.repository​.DireccionRepository​;

@Service
public class DireccionServiceImpl implements DireccionService {

	private static final Logger log = LoggerFactory.getLogger(ControlDeAlumnosApplication.class);

	@Autowired
	DireccionRepository​ repository;
	DireccionDto respuesta;

	@Override
	public DireccionDto save(Direccion direccion) {
		respuesta = new DireccionDto("Error intentando guardar en la BD", "100", new ArrayList<Direccion>());
		try {
			respuesta.getListadoDirecciones().add(repository.save(direccion));
			respuesta.setCodigo("000");
			respuesta.setMensaje("Direccion registrada correctamente");
		} catch (Exception e) {
			log.error("DireccionService -> save : Error " + e);
		}
		return respuesta;

	}

	@Override
	public DireccionDto findAll() {
		respuesta = new DireccionDto("Error intentando leer desde la BD", "100", new ArrayList<Direccion>());
		try {
			respuesta.setListadoDirecciones((List<Direccion>) repository.findAll());
			respuesta.setCodigo("000");
			respuesta.setMensaje("Direcciones cargadas  correctamente");
		} catch (Exception e) {
			log.error("DireccionService -> findAll : Error " + e);
		}
		return respuesta;
	}

}

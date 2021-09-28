package com.edutecno.controlalumnos.service;

import com.edutecno.controlalumnos.dto.DireccionDto;
import com.edutecno.controlalumnos.entity.Direccion;

public interface DireccionService {

	public DireccionDto save(Direccion direccion);

	public DireccionDto findAll();
}

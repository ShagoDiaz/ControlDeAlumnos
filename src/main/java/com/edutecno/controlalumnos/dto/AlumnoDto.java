package com.edutecno.controlalumnos.dto;

import java.util.List;

import com.edutecno.controlalumnos.entity.Alumno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AlumnoDto extends GenericDto {

	private List<Alumno> listadoAlumnos;

	public AlumnoDto(String mensaje, String codigo, List<Alumno> listadoAlumnos) {
		super(mensaje, codigo);
		this.listadoAlumnos = listadoAlumnos;
	}
}

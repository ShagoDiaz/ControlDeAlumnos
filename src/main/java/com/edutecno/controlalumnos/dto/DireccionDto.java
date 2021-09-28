package com.edutecno.controlalumnos.dto;

import java.util.List;

import com.edutecno.controlalumnos.entity.Direccion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DireccionDto extends GenericDto {

	private List<Direccion> listadoDirecciones;

	public DireccionDto(String mensaje, String codigo, List<Direccion> listadoDirecciones) {
		super(mensaje, codigo);
		this.listadoDirecciones = listadoDirecciones;
	}
}

package com.edutecno.controlalumnos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "direccion")
@SequenceGenerator(name = "SQ_DIRECCION", initialValue = 1, sequenceName = "SQ_DIRECCION", allocationSize = 1)
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRECCION")
	private Integer id;
	private String calle;
	private int numero;
	private String ciudad;
	private EnumTipo tipo;
}

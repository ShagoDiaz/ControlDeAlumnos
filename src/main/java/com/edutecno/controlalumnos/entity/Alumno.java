package com.edutecno.controlalumnos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "alumno")
@SequenceGenerator(name = "SQ_Alumno", initialValue = 1, sequenceName = "SQ_Alumno", allocationSize = 1)
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Alumno")
	private Integer id;
	@Column(unique = true)
	private String rut;
	private String nombre;
	private String apellido;
	@Column(unique = true)
	private String email;
	private int edad;
	private String fechaIngreso;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direcion_id", referencedColumnName = "id")
	private Direccion direccion;
}

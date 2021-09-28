package com.edutecno.controlalumnos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutecno.controlalumnos.ControlDeAlumnosApplication;
import com.edutecno.controlalumnos.dto.AlumnoDto;
import com.edutecno.controlalumnos.dto.DireccionDto;
import com.edutecno.controlalumnos.entity.Alumno;
import com.edutecno.controlalumnos.entity.Direccion;
import com.edutecno.controlalumnos.service.AlumnoService​;
import com.edutecno.controlalumnos.service.DireccionService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

	private static final Logger log = LoggerFactory.getLogger(ControlDeAlumnosApplication.class);

	@Autowired
	private AlumnoService​ alumnoService​;
	private AlumnoDto alumnoDto;

	@Autowired
	private DireccionService direccionService​;
	private DireccionDto direccionDto;

	@GetMapping("/listar")
	public String getAllAlumnos(ModelMap model) {
		alumnoDto = alumnoService​.findAll();
		model.addAttribute("alumnos", alumnoDto.getListadoAlumnos());
		return "​alumnos";
	}

	@GetMapping("/crear")
	public String getCrearAlumno(ModelMap model) {
		direccionDto = direccionService​.findAll();
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("direcciones", direccionDto.getListadoDirecciones());
		return "crear-alumno";
	}

	@PostMapping("/crear")
	public String postCrearAlumno(ModelMap model, @ModelAttribute("alumno") Alumno alumno) {
		alumnoService​.save(alumno);
		return "redirect:/alumnos/listar";
	}
}

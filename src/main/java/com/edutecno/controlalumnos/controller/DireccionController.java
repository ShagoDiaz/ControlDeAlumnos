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
import com.edutecno.controlalumnos.dto.DireccionDto;
import com.edutecno.controlalumnos.entity.Direccion;
import com.edutecno.controlalumnos.entity.EnumTipo;
import com.edutecno.controlalumnos.service.DireccionService;

@Controller
@RequestMapping(value = "/direcciones")
public class DireccionController {
	private static final Logger log = LoggerFactory.getLogger(ControlDeAlumnosApplication.class);

	@Autowired
	private DireccionService service;
	private DireccionDto dto;

	@GetMapping("/listar")
	public String getListarDirecciones(ModelMap model) {
		dto = service.findAll();
		model.addAttribute("direcciones", dto.getListadoDirecciones());
		return "direcciones";
	}

	@GetMapping("/crear")
	public String getNuevaDireccion(ModelMap model) {
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("tipos", EnumTipo.values());
		return "crear-direccion";
	}

	@PostMapping("/crear")
	public String postNuevaDireccion(@ModelAttribute("direccion") Direccion direccion) {
		service.save(direccion);
		return "redirect:/direcciones/listar";
	}

}

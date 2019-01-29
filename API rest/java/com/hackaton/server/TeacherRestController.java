package com.hackaton.server;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.google.gson.Gson;

/* Etiquetas obligatorias */
@RestController
@CrossOrigin // Soluciona problemas de compatibilidad navegadores
@RequestMapping("/teacher") // obligatoria para Spring

public class TeacherRestController {
	private List<Teacher> teachers = new ArrayList<>();


	@PostMapping
	//Recuperamos datos Json y los convertimos a nuestrea estructura java de objetos
	public String createTeachers(@RequestBody String json) throws Exception{ //Recibe json por requestBody
		Teacher teacher=new Gson().fromJson(json, Teacher.class); //json se convierte a objeto
		teachers.add(teacher);
		
		return toJson(teacher);
	}
	
	@GetMapping // CTRL+SPACE aparece el texto de la API
	public String getAllTeachers() throws Exception {
	//	Teacher teacher = new Teacher("tyu0007", "B454455", "Ginés", "Gin1", "Gin2", "+34 4543345",1, 2, true);
	//	return "Estos son todos los libros";
		return toJson(teachers);
	}
	
	@GetMapping ("/{id}") // CTRL+SPACE aparece el texto de la API
	public String getTeacher(@PathVariable String id) throws Exception {
		//buscar el profesor
		Teacher teacher = findTeacher(id);
		
		return toJson(teachers);
	}
	
	private Teacher findTeacher(String id) throws Exception{
		for (Teacher b: teachers) {
			if (b.getId().equals(id)) {
				return b;
			}
		}
		throw new Exception();
	}
	/*
	@DeleteMapping
	public void removeAllTeachers() throws Exception {
		teachers= new ArrayList<>();
	}*/
	
	
	private String toJson(Object o) {
		//Librería Gson que le pones objeto y devuelve cadena JSON
		//se debe añadir una línea de implementación en buil.gradle
		return new Gson().toJson(o);
	}
	
}

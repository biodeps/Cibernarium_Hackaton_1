package com.hackaton.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/* Etiquetas obligatorias */
@RestController
@CrossOrigin // Soluciona problemas de compatibilidad navegadores
@RequestMapping("/coordinator") // obligatoria para Spring
public class CoordinatorRestController {
	private List<Coordinator> coordinators = new ArrayList<>();

	@PostMapping
	// PUT Recupera datos del Json y convertimos en objeto Java
	public String createCoordinator(@RequestBody String json) throws Exception {
		Coordinator coordinator = new Gson().fromJson(json, Coordinator.class);
		coordinators.add(coordinator);
		return toJson(coordinator);
	}

	@GetMapping
	public String getAllCoordinators() throws Exception {
		return toJson(coordinators);
	}

	@GetMapping("/{idCoordinator}")
	// GET
	public String getCoordinator(@PathVariable String idCoordinator) throws Exception {
		Coordinator coordinator = findCoordinator(idCoordinator);
		return toJson(coordinator);

	}
	@DeleteMapping
	public void removeAllCoordinators() throws Exception{
		coordinators = new ArrayList<>();
	}
	@PutMapping("/{idCoordinator}")
	// GET
	public String updateCoordinator(@PathVariable String idCoordinator,@RequestBody String json) throws Exception {
		Coordinator coordinatorUpdated = new Gson().fromJson(json, Coordinator.class);
		Coordinator coordinatorOnServer = findCoordinator(idCoordinator);
		
		coordinatorOnServer.updateCoordinator(coordinatorUpdated);

		return toJson(coordinatorOnServer);

	}
	

	private Coordinator findCoordinator(String idCoordinator) throws Exception {

		for (Coordinator c : coordinators) {
			if (c.getIdCoordinator().equals(idCoordinator)) {
				return c;
			}
		}
		throw new Exception();
	}

	private String toJson(Object o) {

		// Librería Gson que le pones objeto y devuelve cadena JSON
		// se debe añadir una línea de implementación en buil.gradle
		return new Gson().toJson(o);
	}
}

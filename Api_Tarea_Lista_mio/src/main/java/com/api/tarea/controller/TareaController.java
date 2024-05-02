package com.api.tarea.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarea.entity.Tarea;
import com.api.tarea.service.ITareaService;

@RestController
@RequestMapping("/api")
public class TareaController {

	@Autowired
	private ITareaService tareaService;

	@GetMapping("/tareas")
	public List<Tarea> buscarTodos() {
		return tareaService.buscarTodos();
	}

	@GetMapping("/tarea/{id}")
	public Tarea buscar(@PathVariable("id") int idtarea) {
		return tareaService.buscar(idtarea);
	}

	@PostMapping("/tarea")
	public List<Tarea> guardar(@RequestBody Tarea tarea) {
		return tareaService.guardar(tarea);
	}
	
	@PostMapping("/tareas")
	public List<Tarea> guardarTodo(@RequestBody List<Tarea> tareas) {
		return tareaService.guardarTodo(tareas);
	}

	@PutMapping("/tarea/{id}")
	public List<Tarea> modificar(@PathVariable("id") int idtarea, @RequestBody Tarea tarea) {
		return tareaService.modificar(idtarea, tarea);
	}

	@DeleteMapping("/tarea/{id}")
	public List<Tarea> eliminar(@PathVariable("id") Integer idtarea) {
		return tareaService.eliminar(idtarea);
	}

	@DeleteMapping("/tareas")
	public List<Tarea> eliminarTodo() {
	return	tareaService.eliminarTodo();
	
	}

}

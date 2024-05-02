package com.api.tarea.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarea.entity.Tarea;
import com.api.tarea.service.ITareaService;


@RestController
@RequestMapping("/api")
public class TareaController {
	
	@Autowired
	private ITareaService tareaService;
	
	@GetMapping("/tareas")
	public List<Tarea> buscarTodos(){
		return tareaService.buscarTodos();
	}
	
	
	@GetMapping("/tarea/{id}")
	public Tarea buscarTarea(@PathVariable("id") int idTarea){
		return tareaService.buscar(idTarea).get();
	}
	
	@PostMapping("/tarea") 
	public Tarea guardar(@RequestBody Tarea tarea) {
		tareaService.guardar(tarea);
		return tarea;
	}
	
	@PostMapping("/tareas") 
	public List<Tarea> guardarTodo(@RequestBody List<Tarea> tareas) {
		tareaService.guardarTodo(tareas);
		return tareas;
	}
	
	@PutMapping("/tarea/{id}")
	public Tarea modificar(@PathVariable("id") int idTarea,@RequestBody Tarea tarea) {
		Tarea tareaBD=tareaService.buscar(idTarea).get();
		tarea.setId(tareaBD.getId());
		tareaService.guardar(tarea);
		return tarea;
	} 
	
	@DeleteMapping("/tarea/{id}")
	public String eliminar(@PathVariable("id") int idTarea) {
		tareaService.eliminar(idTarea);
		return "Registro Eliminado";
	}
	
	@DeleteMapping("/tareas")
	public String eliminarTodo() {
		tareaService.eliminarTodo();
		return "Todos Los Registro Eliminado";
	}
	
	
	@GetMapping("/tarea/estado/{estado}")
	public List<Tarea> eliminar(@PathVariable("estado") String estado) {
		return tareaService.buscarEstado(estado); 
	}
	
	@GetMapping("/tarea/fecha")
	public List<Tarea> eliminar(@RequestParam(name="fecha1") @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha1, @RequestParam(name="fecha2") @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha2) { 
		return tareaService.buscarFecha(fecha1,fecha2); 
	}

}

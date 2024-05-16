package com.api.tarea.service;

import java.util.List;
import java.util.Optional;

import com.api.tarea.entity.Tarea;

 

public interface ITareaService {

	List<Tarea> buscarTodos();
	Tarea guardar(Tarea tarea);
	Tarea actualizar(Tarea tarea);
	void guardarTodo(List<Tarea> tareas);
	void eliminar(int idTarea);
	Optional<Tarea> buscar(int idTarea);
	void eliminarTodo();
}

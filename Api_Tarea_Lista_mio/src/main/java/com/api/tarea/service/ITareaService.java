package com.api.tarea.service;

import java.util.List;
import java.util.Optional;

import com.api.tarea.entity.Tarea;

 

public interface ITareaService {

	List<Tarea> buscarTodos();
	List<Tarea> guardar(Tarea tarea);
	List<Tarea> guardarTodo(List<Tarea> tareas);
	List<Tarea> eliminar(int idTarea);
	//Optional<Tarea> buscar(int idTarea);
	Tarea buscar(int idTarea);
    List<Tarea> modificar(int idTarea,Tarea tarea);
    List<Tarea> eliminarTodo();
}

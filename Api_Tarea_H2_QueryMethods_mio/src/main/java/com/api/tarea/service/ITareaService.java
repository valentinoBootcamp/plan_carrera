package com.api.tarea.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.api.tarea.entity.Tarea;

 

public interface ITareaService {

	List<Tarea> buscarTodos();
	void guardar(Tarea tarea);
	void guardarTodo(List<Tarea> tareas);
	void eliminar(int idTarea);
	Optional<Tarea> buscar(int idTarea);
	void eliminarTodo();
	List<Tarea> buscarEstado(String estado);
	List<Tarea> buscarFecha(Date fecha1,Date fecha2);
}

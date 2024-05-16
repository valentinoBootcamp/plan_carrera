package com.api.tarea.service;

import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.api.tarea.entity.Tarea;
import com.api.tarea.repository.TareaRepository;

@Service
public class TareaServiceImp implements ITareaService {

	@Autowired
	private TareaRepository repositorio;
	
	public List<Tarea> buscarTodos() {
		return repositorio.findAll();
	}

	public Tarea guardar(Tarea tarea) {
		return repositorio.save(tarea);
	}

	public void eliminar(int idTarea) {
		repositorio.deleteById(idTarea);
	}

	@Override
	public Optional<Tarea> buscar(int idTarea) {
		return repositorio.findById(idTarea);
		
	}

	@Override
	public void guardarTodo(List<Tarea> tareas) {
		repositorio.saveAll(tareas);
		
	}

	@Override
	public void eliminarTodo() {
		repositorio.deleteAll();
		
	}

	@Override
	public Tarea actualizar(Tarea tarea) {
		Tarea tareaBD=repositorio.findById(tarea.getId()).get();
		tareaBD.setNombre(tarea.getNombre());
		tareaBD.setDescripcion(tarea.getDescripcion());
		tareaBD.setEstado(tarea.getEstado());
		return repositorio.save(tareaBD);
	}

}

package com.example.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tarea.entity.Tarea;
import com.example.tarea.repository.TareaRepository;
 
@Service
public class TareaServiceImp implements ITareaService {

	@Autowired
	private TareaRepository repositorio;
	
	public List<Tarea> buscarTodos() {
		return repositorio.findAll();
	}

	public void guardar(Tarea tarea) {
		repositorio.save(tarea);
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

}

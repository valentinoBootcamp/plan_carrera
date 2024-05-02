package com.api.tarea.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.tarea.entity.Tarea;

@Service
public class TareaServiceImp implements ITareaService {

	private List<Tarea> lista = getList();

	public List<Tarea> buscarTodos() {
		return lista;
	}

	public List<Tarea> guardar(Tarea tarea) {
		lista.add(tarea);
		return lista;
	}

	 

	@Override
	public List<Tarea> eliminar(int idTarea) {  
		for (Tarea elemento : lista) { 
			if (elemento.getId().equals(idTarea)) {
				lista.remove(idTarea);
				 break;//sale del ciclo al eliminar
			}
		}
		return lista;
	}
	
	@Override
	public List<Tarea> modificar(int idTarea, Tarea tarea) {
		for (Tarea elemento : lista) {
			if (elemento.getId().equals(idTarea)) {
				elemento.setNombre(tarea.getNombre());
				elemento.setDescripcion(tarea.getDescripcion());
				elemento.setFecha(tarea.getFecha());
				elemento.setEstado(tarea.getEstado());
			}
		}

		return lista;
	}

	@Override
	public Tarea buscar(int idTarea) {
		for (Tarea elemento : lista) {
			if (elemento.getId().equals(idTarea)) {
				return elemento;
			}
		}

		return null;
	}

	@Override
	public List<Tarea> guardarTodo(List<Tarea> tareas) {
		  lista.addAll(tareas);
		  return lista;
	}

	@Override
	public List<Tarea> eliminarTodo() {
	   lista.removeAll(lista);
	   return lista;  
	}

	private List<Tarea> getList() {
		lista = new ArrayList<Tarea>();

		Tarea tarea1 = new Tarea();
		tarea1.setId(1);
		tarea1.setNombre("ESTUDIAR");
		tarea1.setDescripcion("ESTUDIAR INGLES");
		tarea1.setFecha(new Date());
		tarea1.setEstado("PENDIENTE");

		Tarea tarea2 = new Tarea();
		tarea2.setId(2);
		tarea2.setNombre("GIMNASIO");
		tarea2.setDescripcion("IR AL GIMNASIO");
		tarea2.setFecha(new Date());
		tarea2.setEstado("FINALIZADO");

		Tarea tarea3 = new Tarea();
		tarea3.setId(3);
		tarea3.setNombre("ESTUDIAR MATEMATICA");
		tarea3.setDescripcion("ESTUDIAR MATEMATICA");
		tarea3.setFecha(new Date());
		tarea3.setEstado("PENDIENTE");

		lista.add(tarea1);
		lista.add(tarea2);
		lista.add(tarea3);

		return lista;
	}

}

package com.api.tarea.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tarea.entity.Tarea;

 

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

	List<Tarea> findByEstado(String estado);
	List<Tarea> findByFechaBetween(Date fecha1,Date fecha2);
}

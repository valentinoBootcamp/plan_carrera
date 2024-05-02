package com.api.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tarea.entity.Tarea;

 

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}

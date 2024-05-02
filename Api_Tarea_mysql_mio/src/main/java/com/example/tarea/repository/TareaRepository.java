package com.example.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarea.entity.Tarea; 
 

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}

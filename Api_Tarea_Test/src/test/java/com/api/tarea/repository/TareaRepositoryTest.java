package com.api.tarea.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.api.tarea.entity.Tarea;

@DataJpaTest
public class TareaRepositoryTest {

	@Autowired
	private TareaRepository tareaRepositorio;

	private Tarea tarea;

	@BeforeEach
	void setup() {
		tarea = Tarea.builder().nombre("HOGAR").descripcion("CORTAR EL PASTO").fecha(null).estado("PENDIENTE").build();
	}

	@DisplayName("Test para guardar una tarea")
	@Test
	void testGuardarTarea() {
		// given

		// when
		Tarea tareaBD = tareaRepositorio.save(tarea);
		// the
		Assertions.assertThat(tareaBD).isNotNull();
		Assertions.assertThat(tareaBD.getId()).isGreaterThan(0);
	}

	@DisplayName("Test para listar las tareas registradas")
	@Test
	void testListarTareas() {
		// given
		Tarea tareaNueva = Tarea.builder().nombre("TRABAJO").descripcion("TESTEAR LAS PRUEBAS").fecha(null)
				.estado("PENDIENTE").build();
		tareaRepositorio.save(tarea);
		tareaRepositorio.save(tareaNueva);
		// when
		List<Tarea> listadoTareas = tareaRepositorio.findAll();
		// then
		Assertions.assertThat(listadoTareas).isNotNull();
		Assertions.assertThat(listadoTareas.size()).isEqualTo(2);
	}

	@DisplayName("Test buscar una tarea especifica por ID")
	@Test
	void testObtenerTareaPorId() {
		// GIVEN
		tareaRepositorio.save(tarea);
		// WHEN
		Tarea tareaBD = tareaRepositorio.findById(tarea.getId()).get();
		// THEN
		Assertions.assertThat(tareaBD).isNotNull();
	}

	@DisplayName("Test para editar una tarea")
	@Test
	void testActualizarTarea() {
		// GIVEN
		tareaRepositorio.save(tarea);

		// WHEN
		Tarea tareaBD = tareaRepositorio.findById(tarea.getId()).get();
		tareaBD.setNombre("LIMPIEZA");
		tareaBD.setDescripcion("LIMPIAR LA HABITACION");
		tareaBD.setEstado("FINALIZADO");
		Tarea tareaActualizadaBD = tareaRepositorio.save(tareaBD);
		// THEN
		assertThat(tareaActualizadaBD.getNombre()).isEqualTo("LIMPIEZA");
		assertThat(tareaActualizadaBD.getEstado()).isEqualTo("FINALIZADO");
	}

	@DisplayName("Test para eliminar una tarea especifica")
	@Test
	void testEliminarTarea() {
		// GIVEN
		tareaRepositorio.save(tarea);

		// WHEN
		tareaRepositorio.deleteById(tarea.getId());
		Optional<Tarea> tareaBD = tareaRepositorio.findById(tarea.getId());

		// THEN
		assertThat(tareaBD).isEmpty();
	}
}

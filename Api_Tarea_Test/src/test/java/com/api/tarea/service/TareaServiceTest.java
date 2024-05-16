package com.api.tarea.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.tarea.entity.Tarea;
import com.api.tarea.repository.TareaRepository;

@ExtendWith(MockitoExtension.class)
public class TareaServiceTest {

	@Mock
	private TareaRepository tareaRepositorio;

	@InjectMocks
	private TareaServiceImp tareaService;

	private Tarea tarea;

	@BeforeEach
	void setup() {
		tarea = Tarea.builder().id(1).nombre("HOGAR").descripcion("CORTAR EL PASTO").fecha(null).estado("PENDIENTE")
				.build();
	}

	@DisplayName("Test para insertar una tarea")
	@Test
	void testGuardarTarea() {

		// GIVEN
		given(tareaRepositorio.save(tarea)).willReturn(tarea);

		// WHEN
		Tarea tareaBD = tareaService.guardar(tarea);

		// THEN
		assertThat(tareaBD).isNotNull();
	}

	@DisplayName("Test para listar todas las tareas")
	@Test
	void testListarTareas() {
		// GIVEN
		Tarea tareaNueva = Tarea.builder().id(1).nombre("LABORAL").descripcion("TESTEAR TODAS LAS PRUEBAS").fecha(null)
				.estado("PENDIENTE").build();
		given(tareaRepositorio.findAll()).willReturn(List.of(tarea, tareaNueva));
		// WHEN
		List<Tarea> tareas = tareaService.buscarTodos();
		// THEN
		assertThat(tareas).isNotNull();
		assertThat(tareas.size()).isEqualTo(2);
	}

	@DisplayName("Test para obtener una tarea por ID")
	@Test
	void testObtenerTareaId() {

		// GIVEN
		given(tareaRepositorio.findById(1)).willReturn(Optional.of(tarea));

		// WHEN
		Tarea tareaBD = tareaService.buscar(tarea.getId()).get();

		// THEN
		assertThat(tareaBD).isNotNull();
	}

	@DisplayName("Test para actualizar una tarea")
	@Test
	void testActualizarTarea() {

		// GIVEN
		given(tareaRepositorio.save(tarea)).willReturn(tarea);
		tarea.setNombre("DEPORTE");
		tarea.setDescripcion("CORRER 4 VUELTAS AL PARQUE");
		tarea.setEstado("PENDIENTE");

		// WHEN
		Tarea tareaActualizadaBD = tareaService.actualizar(tarea);

		// THEN
		assertThat(tareaActualizadaBD.getNombre()).isEqualTo("DEPORTE");
		assertThat(tareaActualizadaBD.getDescripcion()).isEqualTo("CORRER 4 VUELTAS AL PARQUE");
	}

	@DisplayName("Test para eliminar tarea")
	@Test
	void testEliminarTarea() {
		// GIVEN
		Integer idTarea = 1;
		willDoNothing().given(tareaRepositorio).deleteById(idTarea);

		// WHEN
		tareaService.eliminar(idTarea);

		// THEN
		verify(tareaRepositorio).deleteById(idTarea);
	}

}

package com.api.tarea.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.api.tarea.entity.Tarea;
import com.api.tarea.service.ITareaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class TareaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ITareaService tareaService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testInsertarTarea() throws Exception {
		// GIVEN
		Tarea tarea = Tarea.builder().id(1).nombre("HOGAR").descripcion("CORTAR EL PASTO")
				.estado("PENDIENTE").build();
		
		given(tareaService.guardar(any(Tarea.class))).willAnswer((invocation) -> invocation.getArgument(0));

		// WHEN
		ResultActions response = mockMvc.perform(post("/api/tareas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(tarea)));
			
		// THEN 
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.nombre", is(tarea.getNombre())))
		.andExpect(jsonPath("$.descripcion", is(tarea.getDescripcion())))
		.andExpect(jsonPath("$.estado", is(tarea.getEstado())));
	}

}

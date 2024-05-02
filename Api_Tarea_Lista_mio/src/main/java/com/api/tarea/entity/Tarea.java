package com.api.tarea.entity;

import java.util.Date;
 
 

public class Tarea {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private String estado;
	
	
	public Integer getId() {
		return id;
	}
	 
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public Tarea(String nombre, String descripcion, Date fecha, String estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}
	public Tarea() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", estado=" + estado + "]";
	}
	 

	 

}

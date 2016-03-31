package com.wpsnetwork.entidades.muchosAmuchos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante implements Serializable{
	private int id;
	private String nombre;
	private List<Materia> materias;
	
	public Estudiante() {
		super();
	}

	public Estudiante(int id, String nombre, List<Materia> materias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.materias = materias;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable( name = "MATERIAS_ESTUDIANTE",
				joinColumns = @JoinColumn(name = "id_estudiante"),
				inverseJoinColumns = @JoinColumn(name = "id_materia"))
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	
}

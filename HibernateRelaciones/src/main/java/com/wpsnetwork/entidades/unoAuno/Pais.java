package com.wpsnetwork.entidades.unoAuno;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PAISES")
public class Pais implements Serializable{

		private int id;
		private String nombre;
		private Presidente presidente;
		
		public Pais() {
			super();
		}

		public Pais(int id, String nombre, Presidente presidente) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.presidente = presidente;
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

		@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
		@JoinColumn(name="PRESIDENTE")
		public Presidente getPresidente() {
			return presidente;
		}

		public void setPresidente(Presidente presidente) {
			this.presidente = presidente;
		}
}

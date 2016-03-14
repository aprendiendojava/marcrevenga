package com.wpsnetwork.consola;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.wpsnetwork.entidades.muchosAmuchos.Autor;
import com.wpsnetwork.entidades.muchosAmuchos.Estudiante;
import com.wpsnetwork.entidades.muchosAmuchos.Materia;
import com.wpsnetwork.entidades.unoAmuchos.Categoria;
import com.wpsnetwork.entidades.unoAmuchos.Libro;
import com.wpsnetwork.entidades.unoAmuchos.Producto;
import com.wpsnetwork.entidades.unoAuno.Direccion;
import com.wpsnetwork.entidades.unoAuno.Pais;
import com.wpsnetwork.entidades.unoAuno.Persona;
import com.wpsnetwork.entidades.unoAuno.Presidente;

public class App {
    public static void main( String[] args ){
        
    	
    	/*
    	  Relación 1-1 Unidireccional
    	  ===========================
    	  
    	  	CREATE TABLE DIRECCIONES(
    	  		id INTEGER PRIMARY KEY,
    	  		calle VARCHAR2(50),
    	  		codigopostal VARCHAR2(50)
    	  	);
    	  	
    	  	CREATE TABLE PERSONAS(
    	  		id INTEGER PRIMARY KEY,
    	  		nombre VARCHAR2(50),
    	  		direccion INTEGER,
    	  		CONSTRAINT fk_direccion FOREIGN KEY (direccion) REFERENCES direcciones(id)
    	  	);
    	 */
    	
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	Direccion dir = new Direccion(BigDecimal.valueOf(1), "Calle 1", "1111");
//    	Persona p = new Persona(BigDecimal.valueOf(1), dir, "Persona 1");
//    	
//    	sesion.persist(p);
//    	
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
//    	Relaciones 1-1 Bidireccional
//    	=============================
//    	
//    			CREATE TABLE PRESIDENTES(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	 );
//    	    	  	
//    	    	 CREATE TABLE PAISES(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50),
//    	    	  		presidente INTEGER,
//    	    	  		CONSTRAINT fk_presidente FOREIGN KEY (presidente) REFERENCES presidentes(id)
//    	    	  	);
    	
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	Pais pais1 = new Pais(1, "Pais 1", null);
//    	Presidente presidente1 = new Presidente(1, "Presidente 1", pais1);
//    	pais1.setPresidente(presidente1);
//    	
//    	sesion.persist(pais1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
//    	Relaciones 1-N Unidireccional
//    	=============================
//    	
//    			CREATE TABLE PERSONAS_1_N(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	 );
//    	    	  	
//    	    	 CREATE TABLE LIBROS_1_N(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		titulo VARCHAR2(50),
//    	    	  		persona INTEGER,
//    	    	  		CONSTRAINT fk_persona_1_N FOREIGN KEY (persona) REFERENCES personas_1_n(id)
//    	    	  	);
    	
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	com.wpsnetwork.entidades.unoAmuchos.Persona persona1 = 
//    			new com.wpsnetwork.entidades.unoAmuchos.Persona(1, "Persona 1");
//    	
//    	Libro l1 = new Libro(1, "Libro 1", persona1);
//    	Libro l2 = new Libro(2, "Libro 2", persona1);
//    	
//    	sesion.persist(l1);
//    	sesion.persist(l2);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
//    	Relaciones 1-N Bidireccional
//    	=============================
//    	
//    			CREATE TABLE CATEGORIAS(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	 );
//    	    	  	
//    	    	 CREATE TABLE PRODUCTOS(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50),
//    	    	  		categoria INTEGER,
//    	    	  		CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES categorias(id)
//    	    	  	);
    	
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	Categoria cat1 = new Categoria(1, "Categoria 1", new ArrayList<Producto>());
//    	
//    	Producto prod1 = new Producto(1, "Producto 1", cat1);
//    	Producto prod2 = new Producto(2, "Producto 2", cat1);
//    	
//    	cat1.getProductos().add(prod1);
//    	cat1.getProductos().add(prod2);
//    	
//    	sesion.persist(cat1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
    	
    	
//    	Relaciones N-M Unidireccional
//    	=============================
//    	
//    			CREATE TABLE MATERIAS(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	 );
//    	    	  	
//    	    	 CREATE TABLE ESTUDIANTES(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	  	);
//    	
//    			CREATE TABLE MATERIAS_ESTUDIANTE(
//    					id_materia INTEGER,
//    					id_estudiante INTEGER,
//    					CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES materias(id),
//    					CONSTRAINT fk_estudiante FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id),
//    					CONSTRAINT pk_materias_estudiante PRIMARY KEY (id_materia,id_estudiante)
//    		     );
//    	
//    	Session sesion = HibernateUtil.getSession();
//    	sesion.beginTransaction();
//    	
//    	Materia mat1 = new Materia(1, "Materia 1");
//    	Materia mat2 = new Materia(2, "Materia 2");
//    	List<Materia> materias = new ArrayList<>();
//    	
//    	materias.add(mat1);
//    	materias.add(mat2);
//    	
//    	Estudiante est1 = new Estudiante(1, "Estudiante 1", materias);
//    	
//    	sesion.persist(est1);
//    	
//    	sesion.getTransaction().commit();
//    	sesion.close();
    	
    	
//    	Relaciones N-M Bidireccional
//    	=============================
//    	
//    			CREATE TABLE AUTORES(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	 );
//    	    	  	
//    	    	 CREATE TABLE LIBROS_N_M(
//    	    	  		id INTEGER PRIMARY KEY,
//    	    	  		nombre VARCHAR2(50)
//    	    	  	);
//    	
//    			CREATE TABLE LIBROS_AUTORES(
//    					id_libro INTEGER,
//    					id_autor INTEGER,
//    					CONSTRAINT fk_libro_N_M FOREIGN KEY (id_libro) REFERENCES libros_n_m(id),
//    					CONSTRAINT fk_autor FOREIGN KEY (id_autor) REFERENCES autores(id),
//    					CONSTRAINT pk_libros_autores PRIMARY KEY (id_libro,id_autor)
//    		     );
//    	
    	Session sesion = HibernateUtil.getSession();
    	sesion.beginTransaction();
    	
    	Autor autor1 = new Autor(1, "Autor 1", 
    						new ArrayList<com.wpsnetwork.entidades.muchosAmuchos.Libro>());
    	Autor autor2 = new Autor(2, "Autor 2", 
				new ArrayList<com.wpsnetwork.entidades.muchosAmuchos.Libro>());
    	
    	com.wpsnetwork.entidades.muchosAmuchos.Libro libro = 
    			new com.wpsnetwork.entidades.muchosAmuchos.Libro(1, "Libro 1", new ArrayList<Autor>());
    	libro.getAutores().add(autor1);
    	libro.getAutores().add(autor2);
    	
    	autor1.getLibros().add(libro);
    	autor2.getLibros().add(libro);
    	
    	sesion.persist(libro);
    	
    	sesion.getTransaction().commit();
    	sesion.close();
    	
    	
    	HibernateUtil.setDown();
    }
}

package com.youtube.yesidgradlecurso.model;

/**
 * Importaciones de la clase
 */
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Clase padre que hereda el atributo id a todas las subclases de entidad
 * @author Yesid Davila
 */
@MappedSuperclass											// Anotacion que indica a spring que esta es una super clase.
@Access(AccessType.FIELD)									// Permite el acceso a la clase entidad, solo por los atributos (variables), y no por los metodos(get y set).
public class ParentEntity implements Serializable {

	private static final long serialVersionUID = -2398538547740947845L;	// Identificador de la clase serializable.

	@Id														// Anotacion que indica a spring que este atributo es el Id de la tabla representada.
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// Anotacion que indica a spring que este campo es auto numerico (Nota: Si "AUTO" arroja error, enotnces "IDENTITY").
	@Column(name = "id", unique = true, nullable = false)	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	//private Long id;
	private int id;

	//********* Metodos de acceso a la clase (get y set) ******
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// ********************************************************
}
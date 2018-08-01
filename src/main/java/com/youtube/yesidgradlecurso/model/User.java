package com.youtube.yesidgradlecurso.model;	// Paquete al cual pertenece la clase.

// Importaciones de la clase.
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity						// Anotacion para indicar a spring que es una entidad.
@Table(name = "users")	// Anotacion que indica a spring, el nombre de la tabla que se está representando.
@Access(AccessType.FIELD)	// Permite el acceso a la clase entidad, solo por los atributos (variables), y no por los metodos(get y set).
public class User extends ParentEntity{
	
	// Identificador de la clase serializable.
	private static final long serialVersionUID = -3747682770883731953L;

	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "second_name", nullable = true, length = 255)
    private String secondName;
	
	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "first_surname", nullable = false, length = 255)
    private String firstSurname;
	
	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "second_surname", nullable = true, length = 255)
    private String secondSurname;
	
	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "phone", nullable = true, length = 255)
	private String phone;
		
	// Anotacion que indica a spring los atributos de la columna representada en la bd.
	@Column(name = "address", nullable = false, length = 255)
	private String address;

	//********* Metodos de acceso a la clase (get y set) ******
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
	// ********************************************************
}

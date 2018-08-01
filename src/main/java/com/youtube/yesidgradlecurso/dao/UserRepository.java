package com.youtube.yesidgradlecurso.dao;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.youtube.yesidgradlecurso.model.User;

// Clase con acceso a los datos almacenados en la DB.
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Parametro: Crea el registro en la base de datos.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	//@SuppressWarnings("unchecked")
	//User save(User user);

	
	/**
	 * Parametro: Metodo que busca todos los registros en la base de datos.
	 * Retorna:   Lista de Objetos tipo entidad 'User'.
	 */
	//List<User> findAll();
	
	/**
	 * Parametro: Metodo que busca por el nombre de registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	User findByFirstName(String nombre);
	
	/**
	 * Parametro: Metodo que busca por el id del registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	User findById(int id);
}

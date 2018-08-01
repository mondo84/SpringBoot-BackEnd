package com.youtube.yesidgradlecurso.service;

import java.util.List;
import com.youtube.yesidgradlecurso.model.User;

// Interface implementada en la clase que contiene el servicio web.
public interface UserService {

	/**
	 * Parametro: Crea el registro en la base de datos.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	User save(User user);

	/**
	 * Parametro: Metodo que busca todos los registros en la base de datos.
	 * Retorna:   Lista de Objetos tipo entidad 'User'.
	 */
	List<User> findAll();
	
	/**
	 * Parametro: Metodo que busca por el nombre de registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	User findByFirstName(User user);
	
	/**
	 * Parametro: Metodo que busca por el id del registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	User findById(User user);
	
	void deleteUser(int id);
}

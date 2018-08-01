package com.youtube.yesidgradlecurso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youtube.yesidgradlecurso.dao.UserRepository;
import com.youtube.yesidgradlecurso.model.User;

@Service	// Indica a spring que es un servicio.
public class UserServiceImpl implements UserService{

	@Autowired	// Indica la inyeccion de dependencia. (no se hace new())
	UserRepository userRepository;

	/**
	 * Parametro: Crea el registro en la base de datos.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}

	/**
	 * Parametro: Metodo que busca todos los registros en la base de datos.
	 * Retorna:   Lista de Objetos tipo entidad 'User'.
	 */
	@Override	// Metodo que busca por el nombre.
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	
	/**
	 * Parametro: Metodo que busca por el nombre de registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	@Override
	public User findByFirstName(User user) {
		return this.userRepository.findByFirstName(user.getFirstName());
	}
	
	/**
	 * Parametro: Metodo que busca por el id del registro.
	 * Retorna:   Objeto tipo entidad 'User'.
	 */
	@Override
	public User findById(User user) {
		return this.userRepository.findById( user.getId() );
	}

	@Override
	public void deleteUser(int id) {
		this.userRepository.deleteById(id);
	}
}

package com.youtube.yesidgradlecurso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.yesidgradlecurso.model.User;
import com.youtube.yesidgradlecurso.service.UserService;
//import com.youtube.yesidgradlecurso.util.RestResponse;
import com.youtube.yesidgradlecurso.util.RestResponse;


@RestController	// Indica a spring que es una clase de servicio rest.(devuelve los datos en JSON)
//@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	protected UserService userService;	// Inyeccion de dependencia. (no se hace new() para acceder a la clase).	
	protected ObjectMapper mapper; 		/* 	Objeto mapeador de json para poder convertir los 
									  		//datos tipo string o json a datos del tipo EntidadUsuario */
	
	
	             
	//@CrossOrigin(origins = "http://localhost:4200/createUserComponent")
	//@RequestMapping(value = "/user", method = RequestMethod.POST)	// Anotacion de mapeo en la url y el metodo de envio de los datos. POST = Guardar.
	// Anotacion que indica que 'userJson' es un parametro del metodo.
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/userSaveOrUpdate")
	public RestResponse saveOrUpdate(@RequestBody User userJson) {
	//public ResponseEntity<User> saveOrUpdate(@RequestBody User userJson) throws JsonParseException, JsonMappingException, IOException {
		
			
		// Se crea un objeto del tipo 'HttpHeaders'. 
		HttpHeaders httpHeaders = new HttpHeaders();
		
		
			if(!this.validate(userJson)) {	// Si no pasa la validacion de campos obligatorios, en tonces retorna mensaje de error.
				return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios estan vacíos(Boot).");
				
				// Se retorna el objeto 'ResponseEntity<>' con el codigo de no aceptable por el encabezado.
				//return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_ACCEPTABLE);
			}
	
		// Llamado al servicio que guarda o modifica el registro en la BD.
		//User userSaved = this.userService.save(userJson);
		this.userService.save(userJson);
		
		//Se retorna un objeto 'ResponseEntity' con el 'headers' y el código HTTP de respuesta que corresponde a un POST (201 – Created).
		//return  new ResponseEntity<User>(HttpStatus.CREATED);
		
		return new RestResponse(HttpStatus.OK.value(),"Operacion exítosa!"); 
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)	// Anotacion de mapeo en la url y el metodo de envio de los datos. PUT = Modificar.
	public ResponseEntity<User> update(@RequestBody User userJson) throws JsonParseException, JsonMappingException, IOException {
		
		/* this.mapper = new ObjectMapper(); */
	
		//User user = mapper.readValue(userJson, User.class); //this.mapper.readValue(userJson, User.class);
	
	// Se crea un objeto del tipo 'HttpHeaders'. 
	HttpHeaders httpHeaders = new HttpHeaders();
	
		if(!this.validate(userJson)) {	// Si no pasa la validacion de campos obligatorios, en tonces retorna mensaje de error.
			//return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios estan vacíos.");
			
			// Se retorna el objeto 'ResponseEntity<>' con el codigo de no aceptable por el encabezado.
			return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_ACCEPTABLE);
		}

		// Llamado al servicio que guarda o modifica el registro en la BD.
		User userSaved = this.userService.save(userJson);	
		
		// Se setea el 'location' (de tipo URI)
		httpHeaders.setLocation(
	            ServletUriComponentsBuilder
	                    .fromCurrentRequest()
	                    .path("/{firstName}")
	                    .buildAndExpand(userSaved)
	                    .toUri());
	
		//Se retorna un objeto 'ResponseEntity' con el 'headers' y el código HTTP de respuesta que corresponde a un POST (201 – Created).
		return  new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
		
		//return new RestResponse(HttpStatus.OK.value(),"Operacion exítosa!"); 
	}

	@CrossOrigin(origins = "http://localhost:4200")
	//@RequestMapping(value = "/userDelete", method = RequestMethod.DELETE)	// Anotacion de mapeo en la url y el metodo de envio.
	@PostMapping(value = "/userDelete") //@DeleteMapping(value = "/userDelete")
	//public void deleteUser(@RequestBody User userJson) {
	public RestResponse deleteUser(@RequestBody User userJson) {
		
		//userJson.getId();
		try {
			// Llamado al servicio que guarda o modifica el registro en la BD.
			this.userService.deleteUser( userJson.getId() );
			
			return new RestResponse(HttpStatus.OK.value() , "Registro borrado exitosamente!");
		}catch( Exception ex ) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value() , "Ocurrio un error y el registro no ha podido ser borrado!");
		}
		
	}
	
	// @GetMapping("/lista") es la abreviacion o acceso directo a la anotacion: @RequestMapping(value = "/lista", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/lista")	// Anotacion de mapeo en la url y el metodo de envio.
	public List<User> getRegistros(){
		
		return this.userService.findAll();
	}
	
	@RequestMapping(value = "/listaNombre", method = RequestMethod.GET)	// Anotacion de mapeo en la url y el metodo de envio.
	public ArrayList<User> getRegistroPorNombre(@RequestBody User userJson){
		
		ArrayList<User> listaUsuario = new ArrayList<>();	// Array list de usuarios.
		//this.userService.findAll();
		
		User objUser = this.userService.findByFirstName(userJson);	// Objeto de la Interface 'userService' implementada en el servicio 'UserServiceImpl'.
		
		if(objUser != null) {	// Si la busqueda por nombre no devuelve valor null, entonces agrega el dato a la lista de tipo 'CUartos'.
			listaUsuario.add(objUser);
		}
		
		return listaUsuario;
	}
	
	@RequestMapping(value = "/listaId", method = RequestMethod.GET)
	public ArrayList<User> getRegistroPorId(@RequestBody User userJson){
		
		ArrayList<User> listaUsuario = new ArrayList<>();	// Array list de usuarios.
		
		// Llamado al objeto findById().
		User objUser = this.userService.findById(userJson);	// Objeto de la Interface 'userService' implementada en el servicio 'UserServiceImpl'.
		
		if(objUser != null) {	// Si la busqueda por nombre no devuelve valor null, entonces agrega el dato a la lista de tipo 'CUartos'.
			listaUsuario.add(objUser);
		}
		
		return listaUsuario;
	}
	
	// Metodo que valida los campos obligatorios en la base de datos.
		private boolean validate(User user) {
			
			boolean isValid = true;
			
			if( user.getFirstName() == null || user.getFirstName().isEmpty() ) {
				isValid = false;
			}
			
			if( user.getFirstSurname() == null || user.getFirstSurname().isEmpty() ) {
				isValid = false;
			}
			
			if( user.getAddress() == null || user.getAddress().isEmpty() ) {
				isValid = false;
			}
			
			return isValid;
		}
}

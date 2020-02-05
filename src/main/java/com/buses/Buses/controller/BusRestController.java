package com.buses.Buses.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buses.Buses.entity.Buses;
import com.buses.Buses.service.BusService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class BusRestController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private BusService busService;

	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:8080/api/buses*/
	@GetMapping("/buses")
	public List<Buses> findAll(){
		//retornará todos los usuarios
		return busService.findAll();
	}
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/api/buses/1*/
	@GetMapping("/buses/{busId}")
	public Buses getUser(@PathVariable int busId){
		
		Buses bus = busService.findById(busId);
		
		if(bus == null) {
			throw new RuntimeException("Bus id not found -"+busId);
		}
		//retornará al usuario con id pasado en la url
		return bus;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/buses/  */
	@PostMapping("/buses")
	public Buses addUser(@RequestBody Buses bus) {
		bus.setId(0);
		
		//Este metodo guardará al usuario enviado
		busService.save(bus);
		
		return bus;
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/buses/  */
	@PutMapping("/buses")
	public Buses updateUser(@RequestBody Buses bus) {
		
		busService.save(bus);
		
		//este metodo actualizará al usuario enviado
		
		return bus;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del bus
	http://127.0.0.1:8080/api/users/1  */
	@DeleteMapping("buses/{busId}")
	public String deteteUser(@PathVariable int busId) {
		
		Buses bus = busService.findById(busId);
		
		if(bus == null) {
			throw new RuntimeException("User id not found -"+busId);
		}
		
		busService.deleteById(busId);
		
		//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
		return "Deleted user id - "+busId;
	}
	
}
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

import com.buses.Buses.entity.Concessionaire;
import com.buses.Buses.service.ConcessionaireService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class ConcessionaireRestController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private ConcessionaireService concessionaireService;

	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:8080/api/buses*/
	@GetMapping("/concessionaire")
	public List<Concessionaire> findAll(){
		//retornará todos los usuarios
		return concessionaireService.findAll();
	}
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/api/buses/1*/
	@GetMapping("/concessionaire/{concessionaireId}")
	public Concessionaire getConcessionaire(@PathVariable int concessionaireId){
		
		Concessionaire concessionaire = concessionaireService.findById(concessionaireId);
		
		if(concessionaire == null) {
			throw new RuntimeException("Bus id not found -"+concessionaireId);
		}
		//retornará al usuario con id pasado en la url
		return concessionaire;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/buses/  */
	@PostMapping("/concessionaire")
	public Concessionaire addConcessionaire(@RequestBody Concessionaire concessionaire) {
		concessionaire.setId(0);
		
		//Este metodo guardará al usuario enviado
		concessionaireService.save(concessionaire);
		
		return concessionaire;
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/buses/  */
	@PutMapping("/concessionaire")
	public Concessionaire updateConcessionaire(@RequestBody Concessionaire concessionaire) {
		
		concessionaireService.save(concessionaire);
		
		//este metodo actualizará al usuario enviado
		
		return concessionaire;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del bus
	http://127.0.0.1:8080/api/concessionaire/1  */
	@DeleteMapping("concessionaire/{concessionaireId}")
	public String deteteConcessionaire(@PathVariable int concessionaireId) {
		
		Concessionaire concessionaire = concessionaireService.findById(concessionaireId);
		
		if(concessionaire == null) {
			throw new RuntimeException("User id not found -"+concessionaireId);
		}
		
		concessionaireService.deleteById(concessionaireId);
		
		//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
		return "Deleted user id - "+concessionaireId;
	}
	
}
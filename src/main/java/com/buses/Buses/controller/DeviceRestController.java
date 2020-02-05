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

import com.buses.Buses.entity.Device;
import com.buses.Buses.service.DeviceService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class DeviceRestController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private DeviceService deviceService;

	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:8080/api/device*/
	@GetMapping("/device")
	public List<Device> findAll(){
		//retornará todos los dispositivos
		return deviceService.findAll();
	}
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/api/device/1*/
	@GetMapping("/device/{deviceId}")
	public Device getDevice(@PathVariable int deviceId){
		
		Device device = deviceService.findById(deviceId);
		
		if(device == null) {
			throw new RuntimeException("Device id not found -"+deviceId);
		}
		//retornará al usuario con id pasado en la url
		return device;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/device/  */
	@PostMapping("/device")
	public Device addDevice(@RequestBody Device device) {
		device.setId(0);
		
		//Este metodo guardará al usuario enviado
		deviceService.save(device);
		
		return device;
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/device/  */
	@PutMapping("/device")
	public Device updateDevice(@RequestBody Device device) {
		
		deviceService.save(device);
		
		//este metodo actualizará al usuario enviado
		
		return device;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del bus
	http://127.0.0.1:8080/api/device/1  */
	@DeleteMapping("device/{deviceId}")
	public String deteteDevice(@PathVariable int deviceId) {
		
		Device concessionaire = deviceService.findById(deviceId);
		
		if(concessionaire == null) {
			throw new RuntimeException("User id not found -"+deviceId);
		}
		
		deviceService.deleteById(deviceId);
		
		//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
		return "Deleted user id - "+deviceId;
	}
	
}
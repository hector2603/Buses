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

import com.buses.Buses.entity.DeviceType;
import com.buses.Buses.service.DeviceTypeService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class DeviceTypeRestController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private DeviceTypeService deviceService;

	/**
	 * Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:8080/api/deviceType
	*/
	@GetMapping("/deviceType")
	public List<DeviceType> findAll(){
		//retornará todos los dispositivos
		return deviceService.findAll();
	}
	
	/**
	 * Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un dispositivo
	http://127.0.0.1:8080/api/deviceType/1
	*/
	@GetMapping("/deviceType/{deviceId}")
	public DeviceType getDevice(@PathVariable int deviceId){
		
		DeviceType device = deviceService.findById(deviceId);
		
		if(device == null) {
			throw new RuntimeException("Device id not found -"+deviceId);
		}
		//retornará al dispositivo con id pasado en la url
		return device;
	}
	
	/** 
	 * Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/deviceType/  
	*/
	@PostMapping("/deviceType")
	public DeviceType addDevice(@RequestBody DeviceType device) {
		device.setId(0);
		
		//Este metodo guardará al usuario enviado
		deviceService.save(device);
		
		return device;
		
	}
	/**
	 * Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/deviceType/  
	*/
	@PutMapping("/deviceType")
	public DeviceType updateDevice(@RequestBody DeviceType device) {
		
		deviceService.save(device);
		
		//este metodo actualizará al usuario enviado
		
		return device;
	}
	
	/**
	 * Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del dispositivo
	http://127.0.0.1:8080/api/device/1  */
	@DeleteMapping("deviceType/{deviceId}")
	public String deteteDevice(@PathVariable int deviceId) {
		
		DeviceType concessionaire = deviceService.findById(deviceId);
		
		if(concessionaire == null) {
			throw new RuntimeException("User id not found -"+deviceId);
		}
		
		deviceService.deleteById(deviceId);
		
		//Esto método, recibira el id de un dispositivo por URL y se borrará de la bd.
		return "Deleted DeviceType id - "+deviceId;
	}
	
}
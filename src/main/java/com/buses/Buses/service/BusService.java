package com.buses.Buses.service;

import java.util.List;
import com.buses.Buses.entity.Buses;
import com.buses.Buses.entity.Device;

public interface BusService {
	
	public List<Buses> findAll();
	
	public Buses findById(int id);
	
	public void save(Buses user);
	
	public void deleteById(int id);
	
	public List<Device> findDevices(int id);
}

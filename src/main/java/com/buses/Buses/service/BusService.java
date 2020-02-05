package com.buses.Buses.service;

import java.util.List;
import com.buses.Buses.entity.Buses;

public interface BusService {
	
	public List<Buses> findAll();
	
	public Buses findById(int id);
	
	public void save(Buses user);
	
	public void deleteById(int id);
}

package com.buses.Buses.service;

import java.util.List;
import com.buses.Buses.entity.Concessionaire;

public interface ConcessionaireService {
	
	public List<Concessionaire> findAll();
	
	public Concessionaire findById(int id);
	
	public void save(Concessionaire user);
	
	public void deleteById(int id);
}

package com.buses.Buses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buses.Buses.entity.Concessionaire;

public interface ConcessionaireDao  {

	public List<Concessionaire> findAll();
	
	public Concessionaire findById(int id);
	
	public void save(Concessionaire buses);
	
	public void deleteById(int id);
	
}

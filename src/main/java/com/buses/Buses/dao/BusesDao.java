package com.buses.Buses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buses.Buses.entity.Buses;

public interface BusesDao  {

	public List<Buses> findAll();
	
	public Buses findById(int id);
	
	public void save(Buses buses);
	
	public void deleteById(int id);
	
}

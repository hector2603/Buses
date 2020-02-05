package com.buses.Buses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buses.Buses.entity.Device;

public interface DeviceDao  {

	public List<Device> findAll();
	
	public Device findById(int id);
	
	public void save(Device buses);
	
	public void deleteById(int id);
	
}

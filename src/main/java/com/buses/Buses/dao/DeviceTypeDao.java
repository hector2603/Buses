package com.buses.Buses.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buses.Buses.entity.DeviceType;

public interface DeviceTypeDao  {

	public List<DeviceType> findAll();
	
	public DeviceType findById(int id);
	
	public void save(DeviceType buses);
	
	public void deleteById(int id);
	
}

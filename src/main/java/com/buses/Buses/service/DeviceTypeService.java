package com.buses.Buses.service;

import java.util.List;
import com.buses.Buses.entity.DeviceType;

public interface DeviceTypeService {
	
	public List<DeviceType> findAll();
	
	public DeviceType findById(int id);
	
	public void save(DeviceType user);
	
	public void deleteById(int id);
}

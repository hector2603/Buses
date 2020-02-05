package com.buses.Buses.service;

import java.util.List;
import com.buses.Buses.entity.Device;

public interface DeviceService {
	
	public List<Device> findAll();
	
	public Device findById(int id);
	
	public void save(Device user);
	
	public void deleteById(int id);
}

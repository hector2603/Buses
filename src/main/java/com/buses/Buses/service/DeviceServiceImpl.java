package com.buses.Buses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buses.Buses.dao.DeviceDao;
import com.buses.Buses.entity.Device;

@Service
public class DeviceServiceImpl implements DeviceService {
	
	@Autowired
	private DeviceDao deviceDao;

	@Override
	public List<Device> findAll() {
		List<Device> listDevice= deviceDao.findAll();
		return listDevice;
	}

	@Override
	public Device findById(int id) {
		Device device = deviceDao.findById(id);
		return device;
	}

	@Override
	public void save(Device device) {
		deviceDao.save(device);
	}

	@Override
	public void deleteById(int id) {
		deviceDao.deleteById(id);
	}

	
	
}

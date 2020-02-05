package com.buses.Buses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buses.Buses.dao.DeviceTypeDao;
import com.buses.Buses.entity.DeviceType;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
	
	@Autowired
	private DeviceTypeDao deviceDao;

	@Override
	public List<DeviceType> findAll() {
		List<DeviceType> listDevice= deviceDao.findAll();
		return listDevice;
	}

	@Override
	public DeviceType findById(int id) {
		DeviceType device = deviceDao.findById(id);
		return device;
	}

	@Override
	public void save(DeviceType device) {
		deviceDao.save(device);
	}

	@Override
	public void deleteById(int id) {
		deviceDao.deleteById(id);
	}

	
	
}

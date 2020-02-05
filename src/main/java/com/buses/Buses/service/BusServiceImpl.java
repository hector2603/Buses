package com.buses.Buses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buses.Buses.dao.BusesDao;
import com.buses.Buses.entity.Buses;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private BusesDao busesDao;

	@Override
	public List<Buses> findAll() {
		List<Buses> listUsers= busesDao.findAll();
		return listUsers;
	}

	@Override
	public Buses findById(int id) {
		Buses buses = busesDao.findById(id);
		return buses;
	}

	@Override
	public void save(Buses user) {
		busesDao.save(user);
	}

	@Override
	public void deleteById(int id) {
		busesDao.deleteById(id);
	}

	
	
}

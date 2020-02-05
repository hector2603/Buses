package com.buses.Buses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buses.Buses.dao.ConcessionaireDao;
import com.buses.Buses.entity.Concessionaire;

@Service
public class ConcessionaireServiceImpl implements ConcessionaireService {
	
	@Autowired
	private ConcessionaireDao ConcessionaireDao;

	@Override
	public List<Concessionaire> findAll() {
		List<Concessionaire> listConcessionaire= ConcessionaireDao.findAll();
		return listConcessionaire;
	}

	@Override
	public Concessionaire findById(int id) {
		Concessionaire concessionaire = ConcessionaireDao.findById(id);
		return concessionaire;
	}

	@Override
	public void save(Concessionaire concessionaire) {
		ConcessionaireDao.save(concessionaire);
	}

	@Override
	public void deleteById(int id) {
		ConcessionaireDao.deleteById(id);
	}

	
	
}

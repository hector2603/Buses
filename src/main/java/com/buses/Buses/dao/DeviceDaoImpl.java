package com.buses.Buses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.buses.Buses.entity.Device;


@Repository
public class DeviceDaoImpl implements DeviceDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Device> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Device> theQuery = currentSession.createQuery("from Device", Device.class);
		
		List<Device> device = theQuery.getResultList();
		
		return device;

	}

	@Override
	public Device findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Device device = currentSession.get(Device.class, id);
		return device;
	}

	@Transactional
	@Modifying
	@Override
	public void save(Device device) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(device);	
		
	}

	@Transactional
	@Modifying
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Device> theQuery = currentSession.createQuery("delete from Device where id=:idDevice");
		
		theQuery.setParameter("idDevice", id);
		theQuery.executeUpdate();
		
	}

	
}
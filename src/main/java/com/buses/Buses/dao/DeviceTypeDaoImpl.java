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

import com.buses.Buses.entity.DeviceType;


@Repository
public class DeviceTypeDaoImpl implements DeviceTypeDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DeviceType> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<DeviceType> theQuery = currentSession.createQuery("from DeviceType", DeviceType.class);
		
		List<DeviceType> device = theQuery.getResultList();
		
		return device;

	}

	@Override
	public DeviceType findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		DeviceType device = currentSession.get(DeviceType.class, id);
		return device;
	}

	@Transactional
	@Modifying
	@Override
	public void save(DeviceType device) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(device);	
		
	}

	@Transactional
	@Modifying
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<DeviceType> theQuery = currentSession.createQuery("delete from DeviceType where id=:idDevice");
		
		theQuery.setParameter("idDevice", id);
		theQuery.executeUpdate();
		
	}

	
}
package com.buses.Buses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buses.Buses.entity.Buses;


@Repository
public class BusesDaoImpl implements BusesDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Buses> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Buses> theQuery = currentSession.createQuery("from Buses", Buses.class);
		
		List<Buses> users = theQuery.getResultList();
		
		return users;

	}

	@Override
	public Buses findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Buses bus = currentSession.get(Buses.class, id);
		return bus;
	}

	@Override
	public void save(Buses buses) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(buses);	
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Buses> theQuery = currentSession.createQuery("delete from Buses where id=:idBus");
		
		theQuery.setParameter("idBus", id);
		theQuery.executeUpdate();
		
	}

	
}
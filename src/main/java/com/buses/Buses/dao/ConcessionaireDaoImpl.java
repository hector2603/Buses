package com.buses.Buses.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buses.Buses.entity.Concessionaire;


@Repository
public class ConcessionaireDaoImpl implements ConcessionaireDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Concessionaire> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Concessionaire> theQuery = currentSession.createQuery("from Buses", Concessionaire.class);
		
		List<Concessionaire> users = theQuery.getResultList();
		
		return users;

	}

	@Override
	public Concessionaire findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Concessionaire bus = currentSession.get(Concessionaire.class, id);
		return bus;
	}

	@Override
	public void save(Concessionaire buses) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(buses);	
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Concessionaire> theQuery = currentSession.createQuery("delete from Buses where id=:idBus");
		
		theQuery.setParameter("idBus", id);
		theQuery.executeUpdate();
		
	}

	
}
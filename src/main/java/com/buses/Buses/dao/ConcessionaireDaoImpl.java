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

import com.buses.Buses.entity.Concessionaire;


@Repository
public class ConcessionaireDaoImpl implements ConcessionaireDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Concessionaire> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Concessionaire> theQuery = currentSession.createQuery("from Concessionaire", Concessionaire.class);
		
		List<Concessionaire> concessionaires = theQuery.getResultList();
		
		return concessionaires;

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

	@Transactional
	@Modifying
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Concessionaire> theQuery = currentSession.createQuery("delete from Concessionaire where id=:idConcessionaire");
		
		theQuery.setParameter("idConcessionaire", id);
		theQuery.executeUpdate();
		
	}

	
}
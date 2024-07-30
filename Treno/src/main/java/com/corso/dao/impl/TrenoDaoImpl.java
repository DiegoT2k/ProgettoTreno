package com.corso.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.corso.dao.TrenoDao;
import com.corso.model.Fabbrica;
import com.corso.model.Treno;
import com.corso.model.TrenoFilter;
import com.corso.model.Utente;
import javax.persistence.*;

public class TrenoDaoImpl implements TrenoDao{
	
	@PersistenceContext // figlia di Autowired
	
	private EntityManager manager; 
	
	@Override
	public Treno add(Treno treno) {
		manager.persist(treno);
		return treno;
	}

	@Override
	public Utente find(int id) {
		return manager.find(Utente.class, id);
	}

	@Override
	public Fabbrica find(String sigla) {
		return manager.find(Fabbrica.class, sigla);
	}

	@Override
	public Treno findTreno(int id) {
		return manager.find(Treno.class, id);
	}
	
	@Override
	public List<Treno> findAll() {
		Query q = (Query) manager.createQuery("from Treno", Treno.class);
		@SuppressWarnings("unchecked")
		List<Treno> l = q.getResultList();
		return l;
	}
	
	
	
	/**
	 * biglietti_min
	 * biglietti_max
	 * 
	 * prezzoMin
	 * prezzoMax
	 * 
	 * lunghezzaMin
	 * lunghezzaMax
	 * 
	 * pesoMin
	 * pesoMax
	 * 
	 * filtro nome utente
	 * 
	 * cercare stringa all'interno delle sigle
	 * 
	 * 
	 */
	
	@Override
	public List<Treno> findByFilter(TrenoFilter filter){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Treno> criteriaQuery = criteriaBuilder.createQuery(Treno.class);
		Root<Treno> criteriaRoot = criteriaQuery.from(Treno.class);
		
		Predicate p1 = null;
		
		if(filter.getNum_biglietti() != null) {
			p1 = criteriaBuilder.greaterThanOrEqualTo(criteriaRoot.get("biglietti"), filter.getNum_biglietti());
		}
		
		criteriaQuery.where(p1);
		Query query = manager.createQuery(criteriaQuery);
		
		List<Treno> result = query.getResultList();
		return result;
	}

}

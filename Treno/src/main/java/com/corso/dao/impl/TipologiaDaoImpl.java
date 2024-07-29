package com.corso.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corso.dao.TipologiaDao;
import com.corso.model.Fabbrica;
import com.corso.model.Tipologia;

public class TipologiaDaoImpl implements TipologiaDao{

	@PersistenceContext // figlia di Autowired
	
	private EntityManager manager; 
	
	@Override
	public Tipologia add(Tipologia tipologia) {
		manager.persist(tipologia);
		return tipologia;
	}
	
}

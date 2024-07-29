package com.corso.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.base.BaseTest;
import com.corso.config.Beans;
import com.corso.model.abs_vagone.Vagone;

public class VagoneDaoTest extends BaseTest{

	public static void main(String[] args) {
		
		testAddVagone();
		
	}
	
	public static void testAddVagone() {
		stampa("2-testAddVagone");
		
		   BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class); 
		   VagoneDao daoVagone = factory.getBean("vagoneDao", VagoneDao.class); 
		   
		   Vagone vagone = getVagone(daoVagone);
		   daoVagone.add(vagone);
	
	}
	
}

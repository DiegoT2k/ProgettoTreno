package com.corso.base;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.corso.config.Beans;
import com.corso.dao.FabbricaDao;
import com.corso.model.Fabbrica;
import com.corso.model.builder.TrenoBuilder;
import com.corso.model.builder.impl.TrenoItaloBuilder;

public class TrenoBuilderTest extends BaseTest{

	public static void main(String[] args) {
		
		testCreaTreno();
		
	}
	
	public static void testCreaTreno() {
		
		   stampa("1- testCreaTreno");
		   
		   TrenoBuilder t = new TrenoItaloBuilder();
		   t.costruisciTreno("HH");
		   
		   /**
		   BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		   FabbricaDao dao = factory.getBean("fabbricaDao", FabbricaDao.class); 
		   Fabbrica fabbrica = getFabbrica(); 
		   dao.add(fabbrica);
		   System.out.println(fabbrica);
		**/
	}
	
}

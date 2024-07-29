package com.corso.base;

import com.corso.dao.TipologiaDao;
import com.corso.dao.TrenoDao;
import com.corso.dao.UtenteDao;
import com.corso.dao.VagoneDao;
import com.corso.dao.ValutazioneDao;
import com.corso.model.Fabbrica;
import com.corso.model.Tipologia;
import com.corso.model.Treno;
import com.corso.model.Utente;
import com.corso.model.Valutazione;
import com.corso.model.abs_vagone.Vagone;
import com.corso.model.vagone.impl.LocomotivaItalo;
import com.corso.model.vagone.impl.LocomotivaTrenord;

public class BaseTest {

protected static void stampa(String nomeMetodoTest) {
		   System.out.println("-----------------------------------------------------------");
		   System.out.println("invocazione del metodo: " + nomeMetodoTest + "()");
		   System.out.println("-----------------------------------------------------------");
	   }
   
		protected static Utente getUtente() {
			   Utente utente = new Utente();
			   utente.setNome("Paolo");
			   utente.setCognome("Verdi");
			   utente.setEmail("paolo@");
			   utente.setUsername("paolo_verdi");
			   utente.setPassword("abcd");
			   return utente;
		   }	
		   
		protected static Treno getTreno(TrenoDao dao) {
			   Treno treno = new Treno();
			   treno.setId_utente(dao.find(1));
			   treno.setFabbrica(dao.find("IT"));
			   treno.setBiglietti(94);
	
			   return treno;
	   }		
		
		protected static Fabbrica getFabbrica() {
			Fabbrica fabbrica = new Fabbrica();
			fabbrica.setSigla("TN");
			fabbrica.setFabbrica("Trenord");
			
			return fabbrica;
		}
		
		protected static void getSetTreni(Utente utente) {
			System.out.println(utente.getTreni());
		   }	
		
		/**
		protected static Vagone getVagone(VagoneDao dao) {
			Vagone locomotivaItalo = new LocomotivaItalo();

			locomotivaItalo.setId_treno(dao.find(3));
			locomotivaItalo.setLunghezza(100);
			locomotivaItalo.setPeso(10);
			locomotivaItalo.setPrezzo(24);
			locomotivaItalo.setFabbrica(dao.find("IT"));
			locomotivaItalo.setTipo("Locomotiva");
			
			return locomotivaItalo;
		}
		**/
		protected static Vagone getVagone(VagoneDao dao) {
			Vagone locomotivaTrenord = new LocomotivaTrenord();

			locomotivaTrenord.setId_treno(dao.find(4));
			locomotivaTrenord.setLunghezza(59);
			locomotivaTrenord.setPeso(11);
			locomotivaTrenord.setPrezzo(53);
			locomotivaTrenord.setFabbrica(dao.find("TN"));
			locomotivaTrenord.setTipo("Locomotiva");
			
			return locomotivaTrenord;
		}
		
		protected static Tipologia getTipologia() {
			Tipologia tipologia = new Tipologia();
			tipologia.setTipo("Locomotiva");
			return tipologia;
		}
		
		protected static Valutazione getVoto(ValutazioneDao dao) {
			Valutazione voto = new Valutazione();
			voto.setVoto(4);
			voto.setUtente(dao.findUtente(1));
			voto.setTreno(dao.findTreno(3));
			
			return voto;
			
		}
}



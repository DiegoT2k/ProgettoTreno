package com.corso.model;

import javax.persistence.*;

@Entity
public class Tipologia implements Bean{

	@Id
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}

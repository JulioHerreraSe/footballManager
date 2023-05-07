package edu.ucam.pojos;

public class Liga {
	private int id;
	private String nombre;
	
	public Liga(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Liga(int id) {
		super();
		this.id = id;
	}
	
	public Liga(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

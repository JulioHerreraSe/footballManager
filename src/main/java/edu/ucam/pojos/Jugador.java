package edu.ucam.pojos;

public class Jugador {
	private int id;
	private String nombre;
	private String apellido;
	private String posicion;
	private int dorsal;
	private int idClub;
	
	public Jugador(int id, String nombre, String apellido, String posicion, int dorsal, int idClub) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.idClub = idClub;
	}
	
	public Jugador(int id) {
		super();
		this.id = id;
	}

	public Jugador(String nombre, String apellido, String posicion, int dorsal, int idClub) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.posicion = posicion;
		this.dorsal = dorsal;
		this.idClub = idClub;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}
	
	
}

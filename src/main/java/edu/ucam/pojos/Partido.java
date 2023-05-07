package edu.ucam.pojos;

import java.sql.Date;

public class Partido {
	private int id;
	private int idLiga;
	private int idLocal;
	private int idVisitante;
	private Date fecha;
	private int golesLocal;
	private int golesVisitante;
	
	public Partido(int id, int idLiga, int idLocal, int idVisitante, Date fecha, int golesLocal, int golesVisitante) {
		super();
		this.id = id;
		this.idLiga = idLiga;
		this.idLocal = idLocal;
		this.idVisitante = idVisitante;
		this.fecha = fecha;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	
	public Partido(int idLiga, int idLocal, int idVisitante, Date fecha, int golesLocal, int golesVisitante) {
		super();
		this.idLiga = idLiga;
		this.idLocal = idLocal;
		this.idVisitante = idVisitante;
		this.fecha = fecha;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	public Partido(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

}

package edu.ucam.pojos;

public class Club {
	private int id;
	private String nombre;
	private int puntos;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesFavor;
	private int golesContra;
	private int idLiga;

	public Club(int id, String nombre, int puntos, int partidosGanados, int partidosEmpatados, int partidosPerdidos, int golesFavor,
			int golesContra, int idLiga) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
		this.partidosGanados = partidosGanados;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosPerdidos = partidosPerdidos;
		this.golesFavor = golesFavor;
		this.golesContra = golesContra;
		this.idLiga = idLiga;
	}
	
	public Club(int id, String nombre, int idLiga) {
		this.id = id;
		this.nombre = nombre;
		this.idLiga = idLiga;
	}
	
	public Club(String nombre, int idLiga) {
		this.nombre = nombre;
		this.idLiga = idLiga;
	}
	
	public Club(int id) {
		this.id = id;
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

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getGolesFavor() {
		return golesFavor;
	}

	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}

	public int getGolesContra() {
		return golesContra;
	}

	public void setGolesContra(int golesContra) {
		this.golesContra = golesContra;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	@Override
	public String toString() {
		return nombre+" "+partidosGanados+" "+partidosEmpatados+" "+partidosPerdidos+" "+golesFavor+" "+golesContra;
	}
	
	
	
}

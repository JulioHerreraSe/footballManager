package edu.ucam.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.ucam.pojos.Partido;

public class PartidoDAOSQL extends PartidoDAO{
	private DataSource dataSource;
	private String SQLSelect = "SELECT * FROM partido";
	private String SQLSelectById = "SELECT * FROM partido WHERE id = ?";
	private String SQLInsert = "INSERT INTO partido(liga_id,local_id,visitante_id,fecha,resultado_local,resultado_visitante) VALUES(?,?,?,?,?,?)";
	private String SQLUpdate = "UPDATE partido SET fecha=?, resultado_local=?, resultado_visitante=? WHERE id = ?";
	private String SQLDelete = "DELETE FROM partido WHERE id = ?";
	
	public PartidoDAOSQL() throws NamingException {
		Context initContext = new InitialContext();
	    Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    dataSource = (DataSource)envContext.lookup("jdbc/mydb");
	}
	
	
	public List<Partido> listar() throws NamingException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Partido> partidos = new ArrayList<Partido>();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int idLiga = rs.getInt("liga_id");
				int idLocal = rs.getInt("local_id");
				int idVisitante = rs.getInt("visitante_id");
				Date fecha = rs.getDate("fecha");
				int golesLocal = rs.getInt("resultado_local");
				int golesVisitante = rs.getInt("resultado_visitante");
			
				partidos.add(new Partido(id,idLiga,idLocal,idVisitante,fecha,golesLocal,golesVisitante));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return partidos;
	}
	
	public Partido buscar(Partido partido) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLSelectById);
			// Añadimos el parametro necesario
			ps.setInt(1, partido.getId());
			// Ejecutamos la consulta
			rs = ps.executeQuery();
			// Cargamos el club
			rs.next();
			// Ponemos los atributos del club
			
			partido.setIdLiga(rs.getInt("liga_id"));
			partido.setIdLocal(rs.getInt("local_id"));
			partido.setIdVisitante(rs.getInt("visitante_id"));
			partido.setFecha(rs.getDate("fecha"));
			partido.setGolesLocal(rs.getInt("resultado_local"));
			partido.setGolesVisitante(rs.getInt("resultado_visitante"));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return partido;
	}
	
	public void insertar(Partido partido) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLInsert);
			ps.setInt(1, partido.getIdLiga());
			ps.setInt(2, partido.getIdLocal());
			ps.setInt(3, partido.getIdVisitante());
			ps.setDate(4, (java.sql.Date) partido.getFecha());
			ps.setInt(5, partido.getGolesLocal());
			ps.setInt(6, partido.getGolesVisitante());
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("partido Insertado");
	}
	
	public void actualizar(Partido partido) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLUpdate);
			ps.setDate(1, partido.getFecha());
			ps.setInt(2, partido.getGolesLocal());
			ps.setInt(3, partido.getGolesVisitante());
			ps.setInt(4, partido.getId());
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Liga Actualizada");
	}
	
	public void eliminar(Partido partido) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLDelete);
			// Añadimos el parametro necesario
			ps.setInt(1, partido.getId());
			// Ejecutamos la consulta
			ps.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// Mensaje para el servidor
		System.out.println("partido eliminado");
	}
	
}

package edu.ucam.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.ucam.pojos.Jugador;

public class JugadorDAOSQL extends JugadorDAO{
	private DataSource dataSource;
	private String SQLSelect = "SELECT * FROM jugador";
	private String SQLSelectById = "SELECT * FROM jugador WHERE id = ?";
	private String SQLInsert = "INSERT INTO jugador(nombre,apellido,posicion,dorsal,club_id) VALUES(?,?,?,?,?)";
	private String SQLUpdate = "UPDATE jugador SET nombre=?, apellido=?, posicion=?, dorsal=?, club_id=? WHERE id = ?";
	private String SQLDelete = "DELETE FROM jugador WHERE id = ?";
	
	public JugadorDAOSQL() throws NamingException {
		Context initContext = new InitialContext();
	    Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    dataSource = (DataSource)envContext.lookup("jdbc/mydb");
	}
	
	
	public List<Jugador> listar() throws NamingException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String posicion = rs.getString("posicion");
				int dorsal = rs.getInt("dorsal");
				int idEquipo = rs.getInt("club_id");
			
				jugadores.add(new Jugador(id,nombre,apellido,posicion,dorsal,idEquipo));
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
		return jugadores;
	}
	
	public Jugador buscar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelectById);
			ps.setInt(1, jugador.getId());
			rs = ps.executeQuery();
			rs.next();
				
			jugador.setNombre(rs.getString("nombre"));
			jugador.setApellido(rs.getString("apellido"));
			jugador.setPosicion(rs.getString("posicion"));
			jugador.setDorsal(rs.getInt("dorsal"));
			jugador.setIdClub(rs.getInt("club_id"));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jugador;
	}
	
	public void insertar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLInsert);
			ps.setString(1, jugador.getNombre());
			ps.setString(2, jugador.getApellido());
			ps.setString(3, jugador.getPosicion());
			ps.setInt(4, jugador.getDorsal());
			ps.setInt(5, jugador.getIdClub());
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
		System.out.println("Jugador Insertado");
	}
	
	public void actualizar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLUpdate);
			ps.setString(1, jugador.getNombre());
			ps.setString(2, jugador.getApellido());
			ps.setString(3, jugador.getPosicion());
			ps.setInt(4, jugador.getDorsal());
			ps.setInt(5, jugador.getIdClub());
			ps.setInt(6, jugador.getId());
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
		System.out.println("Jugador Actualizado");
	}
	
	public void eliminar(Jugador jugador) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLDelete);
			ps.setInt(1, jugador.getId());
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
		System.out.println("Jugador eliminado");
	}
	
}

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

import edu.ucam.pojos.Liga;

public class LigaDAOSQL extends LigaDAO{
	private DataSource dataSource;
	private String SQLSelect = "SELECT * FROM liga";
	private String SQLSelectById = "SELECT * FROM liga WHERE id = ?";
	private String SQLInsert = "INSERT INTO liga(nombre) VALUES(?)";
	private String SQLUpdate = "UPDATE liga SET nombre=? WHERE id = ?";
	private String SQLDelete = "DELETE FROM liga WHERE id = ?";
	
	public LigaDAOSQL() throws NamingException {
		Context initContext = new InitialContext();
	    Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    dataSource = (DataSource)envContext.lookup("jdbc/mydb");
	}
	
	
	public List<Liga> listar() throws NamingException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Liga> ligas = new ArrayList<Liga>();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
			
				ligas.add(new Liga(id,nombre));
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
		return ligas;
	}
	
	public Liga buscar(Liga liga) {
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
			ps.setInt(1, liga.getId());
			// Ejecutamos la consulta
			rs = ps.executeQuery();
			// Cargamos el club
			rs.next();
			// Ponemos los atributos del club
			liga.setNombre(rs.getString("nombre"));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return liga;
	}
	
	public void insertar(Liga liga) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLInsert);
			ps.setString(1, liga.getNombre());
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
		System.out.println("Liga Insertada");
	}
	
	public void actualizar(Liga liga) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLUpdate);
			ps.setString(1, liga.getNombre());
			ps.setInt(2, liga.getId());
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
	
	public void eliminar(Liga liga) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLDelete);
			// Añadimos el parametro necesario
			ps.setInt(1, liga.getId());
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
		System.out.println("Liga eliminada");
	}
	
}

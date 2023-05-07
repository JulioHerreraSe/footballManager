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

import edu.ucam.pojos.Club;


public class ClubDAOSQL extends ClubDAO{
	// Atributos 
	private DataSource dataSource;
	// Consultas SQL
	private String SQLSelect = "SELECT * FROM club";
	private String SQLSelectById = "SELECT * FROM club WHERE id = ?";
	private String SQLInsert = "INSERT INTO club(nombre,liga_id) VALUES(?,?)";
	private String SQLUpdate = "UPDATE club SET nombre=?, puntos=?, partidos_ganados=?, partidos_empatados=?, partidos_perdidos=?, goles_a_favor=?, goles_en_contra=?, liga_id=? WHERE id = ?";
	private String SQLDelete = "DELETE FROM club WHERE id = ?";
	
	// Constructos con los datos de conexion a la base de datos
	public ClubDAOSQL() throws NamingException {
		Context initContext = new InitialContext();
	    Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    dataSource = (DataSource)envContext.lookup("jdbc/mydb");
	}
	
	// Metodo para listar a los clubs de la base de datos
	public List<Club> listar() throws NamingException{
		// Instanciamos a nulo los objetos
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Club> clubs = new ArrayList<Club>();
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLSelect);
			// Ejecutamos la consulta
			rs = ps.executeQuery();
			// Recorremos la consulta
			while (rs.next()) {
				// Recogemos los atributos
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int puntos = rs.getInt("puntos");
				int partidosGanados = rs.getInt("partidos_ganados");
				int partidosEmpatados = rs.getInt("partidos_empatados");
				int partidosPerdidos = rs.getInt("partidos_perdidos");
				int golesFavor = rs.getInt("goles_a_favor");
				int golesContra = rs.getInt("goles_en_contra");
				int idLiga = rs.getInt("liga_id");
				// Metemos los clubs en la lista
				clubs.add(new Club(id,nombre,puntos,partidosGanados,partidosEmpatados,partidosPerdidos,golesFavor,golesContra,idLiga));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				// Cerramos la conexion
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// Deviolvemos la lista de club
		return clubs;
	}
	
	public Club buscar(Club club) {
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
			ps.setInt(1, club.getId());
			// Ejecutamos la consulta
			rs = ps.executeQuery();
			// Cargamos el club
			rs.next();
			// Ponemos los atributos del club
			club.setNombre(rs.getString("nombre"));
			club.setIdLiga(rs.getInt("liga_id"));
			club.setPuntos(rs.getInt("puntos"));
			club.setPartidosGanados(rs.getInt("partidos_ganados"));
			club.setPartidosEmpatados(rs.getInt("partidos_empatados"));
			club.setPartidosPerdidos(rs.getInt("partidos_perdidos"));
			club.setGolesFavor(rs.getInt("goles_a_favor"));
			club.setGolesContra(rs.getInt("goles_en_contra"));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return club;
	}
	
	public void insertar(Club club) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLInsert);
			// Añadimos el parametro necesario
			ps.setString(1, club.getNombre());
			ps.setInt(2, club.getIdLiga());
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
		System.out.println("Club Insertado");
	}
	
	public void actualizar(Club club) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLUpdate);
			// Añadimos los parametros necesarios
			ps.setString(1, club.getNombre());
			ps.setInt(2, club.getPuntos());
			ps.setInt(3, club.getPartidosGanados());
			ps.setInt(4, club.getPartidosEmpatados());
			ps.setInt(5, club.getPartidosPerdidos());
			ps.setInt(6, club.getGolesFavor());
			ps.setInt(7, club.getGolesContra());
			ps.setInt(8, club.getIdLiga());
			ps.setInt(9, club.getId());
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
		System.out.println("Club Actualizado");
	}
	
	public void eliminar(Club club) {
		// Hacemos la conexion
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// Hacemos la conexion con la base de datos
			conn = dataSource.getConnection();
			// Cargamos la consulta
			ps = conn.prepareStatement(SQLDelete);
			// Añadimos el parametro necesario
			ps.setInt(1, club.getId());
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
		System.out.println("Club eliminado");
	}
	
}
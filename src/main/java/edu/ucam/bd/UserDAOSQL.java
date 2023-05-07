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

import edu.ucam.pojos.User;

public class UserDAOSQL extends UserDAO{
	private DataSource dataSource;
	private String SQLSelect = "SELECT * FROM usuario";
	private String SQLSelectById = "SELECT * FROM usuario WHERE id = ?";
	private String SQLValidar = "SELECT count(*) AS cantidad FROM usuario WHERE name=? and pass=?";
	private String SQLInsert = "INSERT INTO usuario(name,pass) VALUES(?,?)";
	private String SQLUpdate = "UPDATE usuario SET name=?, pass=? WHERE id = ?";
	private String SQLDelete = "DELETE FROM usuario WHERE id = ?";
	
	public UserDAOSQL() throws NamingException {
		Context initContext = new InitialContext();
	    Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    dataSource = (DataSource)envContext.lookup("jdbc/mydb");
	}
	
	
	public List<User> listar() throws NamingException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelect);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
			
				users.add(new User(id,name,pass));
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
		
		return users;
	}
	
	public User buscar(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLSelectById);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			rs.next();
				
			user.setName(rs.getString("name"));
			user.setPass(rs.getString("pass"));
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void insertar(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLInsert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
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
		
		System.out.println("Usuario insertado");
	}
	
	public void actualizar(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLUpdate);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getId());
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
		
		System.out.println("Usuario actualizado");
	}
	
	public void eliminar(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLDelete);
			ps.setInt(1, user.getId());
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
		
		System.out.println("Usuario eliminado");
	}
	
	public int Validar(User user) throws NamingException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(SQLValidar);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			rs = ps.executeQuery();
			rs.next();
			cantidad = rs.getInt("cantidad");
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cantidad;
	}
	
}

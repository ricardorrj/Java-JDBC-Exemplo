package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionJdbc.dbEngine;
import model.Users;

public class UserDao {

	private Connection connection;
	
	/*Construtor chamando a conexão com banco para o atributo connection*/
	public UserDao() {
		connection = dbEngine.getConnection();
	}
	
	
	public void save(Users users) {
		try {
			String sql = "INSERT INTO registerusers(name, email, celular, datacadastro) VALUES (?, ?, ?, CURRENT_DATE);";
			PreparedStatement query = connection.prepareStatement(sql);
			
			query.setString(1, users.getName());
			query.setString(2, users.getEmail());
			query.setString(3, users.getCelular());
			
			query.execute();
			connection.commit();
			
			System.out.println("Informação Registrada com Sucesso!");	
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public Users loadById(Integer id) throws SQLException{
		
		Users users = new Users();

		String sql = "SELECT ID, NAME, EMAIL, CELULAR FROM registerusers WHERE ID = ?";
		PreparedStatement query = connection.prepareStatement(sql);
			
		query.setInt(1, id);	
		ResultSet resultSet = query.executeQuery();
		
		while(resultSet.next()) {
			users.setId(resultSet.getInt("ID"));
			users.setName(resultSet.getString("NAME"));
			users.setEmail(resultSet.getString("EMAIL"));
			users.setCelular(resultSet.getString("CELULAR"));
		}
			
		return users;
	}
	
	
	public List<Users> listUsers(){
		
		List<Users> list = new ArrayList<Users>();
		String sql = "SELECT ID, NAME, EMAIL, CELULAR FROM registerusers WHERE 1 = 1;";
		
		try {
			PreparedStatement query = connection.prepareStatement(sql);
			
			ResultSet result = query.executeQuery();
			
			while(result.next()) {
				Users searchUsers = new Users();
				
				searchUsers.setId(result.getInt("ID"));
				searchUsers.setName(result.getString("NAME"));
				searchUsers.setEmail(result.getString("EMAIL"));
				searchUsers.setCelular(result.getString("CELULAR"));
				
				list.add(searchUsers);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return list;
	}
	
	
	
	public void updateUser(Users users) {
		try {
			String sql = "UPDATE registerusers SET name = ?, email = ?, celular = ?, dataalteracao = CURRENT_DATE WHERE id = ?;";
			PreparedStatement query = connection.prepareStatement(sql);
			
			query.setString(1, users.getName());
			query.setString(2, users.getEmail());
			query.setString(3, users.getCelular());
			query.setInt(4, users.getId());
			
			query.executeUpdate();
			connection.commit();
			
			System.out.println("Informação Atualizada com sucesso!");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void delete(Integer id) {
		try {
			String sql = "DELETE FROM registerusers WHERE id = "+id+";";
			PreparedStatement query = connection.prepareStatement(sql);
			
			query.execute();
			connection.commit();
			
			System.out.println("Informação Excluida com sucesso!");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
}

package com.hosptial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosptial.entity.User;

public class UserDao {

	private Connection connection;

	public UserDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean saveUser(String name, String email, String password) throws SQLException {

		boolean flag = false;

		String sqlString = "insert into hospital(name,email,password)values(?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, password);

		int i = preparedStatement.executeUpdate();

		if (i == 1) {

			flag = true;

		}
		return flag;
	}
	
	
	//login
	//LOGIN
	public User loginUser(String email,String password) throws SQLException
	{
		User user=null;
		
		String qeryString="select * from  hospital where email=? and password=?";
		
		
		PreparedStatement pStatement=connection.prepareStatement(qeryString);
		pStatement.setString(1, email);
		pStatement.setString(2, password);
		
		
		      ResultSet rsResultSet=  pStatement.executeQuery();
		      User user2=null;
		      
		      while (rsResultSet.next()) {
		    	  user2=new User();
		    	  user2.setId(rsResultSet.getInt(1));
		    	  user2.setName(rsResultSet.getString(2));
		    	  user2.setEmail(rsResultSet.getString(3));
		    	  user2.setPassword(rsResultSet.getString(4));
		    	 
			}
			return user2;
	}
	
	
	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from  hospital where id=? and password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update  hospital set password=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	

}

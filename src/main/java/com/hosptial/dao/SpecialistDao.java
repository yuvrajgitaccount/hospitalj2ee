package com.hosptial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hosptial.entity.Specialist;

public class SpecialistDao {

	
	
	
	private Connection connection;

	 public SpecialistDao (Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean saveSpcalist(String spcailistname) throws SQLException {

		boolean flag = false;

		String sqlString = "insert into spicalist(spcailistname)values(?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

		preparedStatement.setString(1,spcailistname);
	

		int i = preparedStatement.executeUpdate();

		if (i == 1) {

			flag = true;

		}
		return flag;
	}
	
	
	//fetch speclisit data
	
	
	public List<Specialist>getAllSpecilist() throws SQLException
	{
		List<Specialist>list=new ArrayList<Specialist>();
		
		Specialist specialist=null;
		
		
		String string="select * from spicalist";
		
		PreparedStatement preparedStatement=connection.prepareStatement(string);
		
		
	ResultSet resultSet=	  preparedStatement.executeQuery();
	
	while (resultSet.next()) {
		
		specialist=new Specialist();
		
		specialist.setId(resultSet.getInt(1));
		specialist.setSpcailistname(resultSet.getString(2));
		
		list.add(specialist);
		
	}
	return list;
	}
	
}

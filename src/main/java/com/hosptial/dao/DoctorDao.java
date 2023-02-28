package com.hosptial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hosptial.entity.Doctor;
import com.hosptial.entity.User;

public class DoctorDao {

	private Connection connection;

	public DoctorDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean saveDoctor(String name, String dob, String quali, String spcailistname, String email, String mobno,
			String password) throws SQLException {

		boolean flag = false;

		String sqlString = "insert into doctor(name,dob,quali,spcailistname,email,mobno,password)values(?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

		preparedStatement.setString(1, name);
		preparedStatement.setString(2, dob);
		preparedStatement.setString(3, quali);
		preparedStatement.setString(4, spcailistname);
		preparedStatement.setString(5, email);
		preparedStatement.setString(6, mobno);
		preparedStatement.setString(7, password);

		int i = preparedStatement.executeUpdate();

		if (i == 1) {

			flag = true;

		}
		return flag;
	}

	// Doctor GetAll data

	public List<Doctor> getAllDoctor() throws SQLException {
		List<Doctor> list = new ArrayList<Doctor>();

		Doctor doctor = null;

		String string = "select * from doctor order by id asc ";

		PreparedStatement preparedStatement = connection.prepareStatement(string);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			doctor = new Doctor();

			doctor.setId(resultSet.getInt(1));
			doctor.setName(resultSet.getString(2));
			doctor.setDob(resultSet.getString(3));
			doctor.setQuali(resultSet.getString(4));
			doctor.setSpcailistname(resultSet.getString(5));
			doctor.setEmail(resultSet.getString(6));
			doctor.setMobno(resultSet.getString(7));
			doctor.setPassword(resultSet.getString(8));
			list.add(doctor);
		}
		return list;
	}
	
	
	//find by id  DFoctor
	
	
	public Doctor getByDoctoriD(int id) throws SQLException
	{
		
		Doctor doctor=null;
		
		String string="select * from doctor where id=?";
		
		PreparedStatement preparedStatement=connection.prepareStatement(string);
		
		preparedStatement.setInt(1, id);
		
		
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			doctor = new Doctor();

			doctor.setId(resultSet.getInt(1));
			doctor.setName(resultSet.getString(2));
			doctor.setDob(resultSet.getString(3));
			doctor.setQuali(resultSet.getString(4));
			doctor.setSpcailistname(resultSet.getString(5));
			doctor.setEmail(resultSet.getString(6));
			doctor.setMobno(resultSet.getString(7));
			doctor.setPassword(resultSet.getString(8));
		
		}
		return doctor;
		
	}

	
	//Doctor update
	
	
	//update data

		public boolean updataDoctor(Doctor doctor)
		{
			boolean flag=false;
			String string="update doctor  set name=?,dob=?,quali=?,spcailistname=?,email=?,mobno=?,password=? where id=?";
			
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(string);
				
				preparedStatement.setString(1, doctor.getName());
				preparedStatement.setString(2, doctor.getDob());
				preparedStatement.setString(3, doctor.getQuali());
				preparedStatement.setString(4, doctor.getSpcailistname());
				preparedStatement.setString(5, doctor.getEmail());
				preparedStatement.setString(6, doctor.getMobno());
				preparedStatement.setString(7, doctor.getPassword());
				preparedStatement.setInt(8,doctor.getId());
			
				
				int i=preparedStatement.executeUpdate();
				if (i==1) {
					
					flag=true;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
		}

		
		//boolean
		 
				public boolean DeleteById(int id)
				{
					boolean flag=false;
					
					
					try {
						
						String sqlString="delete from doctor where id=?";
						
						PreparedStatement pStatement=connection.prepareStatement(sqlString);
						pStatement.setInt(1, id);
						
					int i=	pStatement.executeUpdate();
					
					if (i==1) {
						
						flag=true;
						
					}
						
						
						
					} catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					return flag;
				}
				
				
				
	//Doctor login
				
				//login
				//LOGIN
				public Doctor loginUser(String email,String password) throws SQLException
				{
					Doctor doctor=null;
					
					String qeryString="select * from  doctor where email=? and password=?";
					
					
					PreparedStatement pStatement=connection.prepareStatement(qeryString);
					pStatement.setString(1, email);
					pStatement.setString(2, password);
					
					
					      ResultSet resultSet=  pStatement.executeQuery();
					      
					      
					      while (resultSet.next()) {
					    	  doctor=new Doctor();
					    	  doctor.setId(resultSet.getInt(1));
								doctor.setName(resultSet.getString(2));
								doctor.setDob(resultSet.getString(3));
								doctor.setQuali(resultSet.getString(4));
								doctor.setSpcailistname(resultSet.getString(5));
								doctor.setEmail(resultSet.getString(6));
								doctor.setMobno(resultSet.getString(7));
								doctor.setPassword(resultSet.getString(8));
					    	
					    	 
						}
						return doctor;
				}
				
				
				
				
				public int countDoctor() {
					int i = 0;
					try {
						String sql = "select * from doctor";
						PreparedStatement ps = connection.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							i++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return i;
				}

				public int countAppointment() {
					int i = 0;
					try {
						String sql = "select * from appointment";
						PreparedStatement ps = connection.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							i++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return i;
				}

				public int countAppointmentByDocotrId(int did) {
					int i = 0;
					try {
						String sql = "select * from appointment where doctorid=?";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setInt(1, did);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							i++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return i;
				}

				public int countUSer() {
					int i = 0;
					try {
						String sql = "select * from hospital";
						PreparedStatement ps = connection.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							i++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return i;
				}

				public int countSpecialist() {
					int i = 0;
					try {
						String sql = "select * from spicalist";
						PreparedStatement ps = connection.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							i++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return i;
				}

				public boolean checkOldPassword(int userid, String oldPassword) {
					boolean f = false;

					try {
						String sql = "select * from doctor where id=? and password=?";
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
						String sql = "update doctor set password=? where id=?";
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

				public boolean editDoctorProfile(Doctor d) {
					boolean f = false;

					try {
						String sql = "update doctor set name=?,dob=?,quali=?,spcailistname=?,email=?,mobno=? where id=?";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setString(1, d.getName());
						ps.setString(2, d.getDob());
						ps.setString(3, d.getQuali());
						ps.setString(4, d.getSpcailistname());
						ps.setString(5, d.getEmail());
						ps.setString(6, d.getMobno());
						ps.setInt(7, d.getId());
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



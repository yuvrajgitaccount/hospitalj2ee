package com.hosptial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hosptial.entity.Appointment;

public class AppointmentDao {

	private Connection connection;

	public AppointmentDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public boolean saveAppoint(Integer userid, String fullname, String gender, String age, String appointdate,
			String email, String phno, String diseases, int doctorid, String address, String status)
			throws SQLException {

		boolean flag = false;

		String sqlString = "insert into appointment(userid,fullname,gender,age,appointdate,email,phno,diseases,doctorid,address,status)values(?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

		preparedStatement.setInt(1, userid);
		preparedStatement.setString(2, fullname);
		preparedStatement.setString(3, gender);
		preparedStatement.setString(4, age);
		preparedStatement.setString(5, appointdate);
		preparedStatement.setString(6, email);
		preparedStatement.setString(7, phno);
		preparedStatement.setString(8, diseases);
		preparedStatement.setInt(9, doctorid);
		preparedStatement.setString(10, address);
		preparedStatement.setString(11, status);

		int i = preparedStatement.executeUpdate();

		if (i == 1) {
			flag = true;

		}
		return flag;

	}

	// getAll Appoint By userid

	public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where userid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoindate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// getAll Appointment by doctorid

	public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where doctorid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, doctorId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoindate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// getAll Appointment id
	public Appointment getAppointmentById(int id) {

		Appointment ap = null;

		try {

			String sql = "select * from appointment where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoindate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}

	public boolean updateCommentStatus(int id, int did, String comm) throws SQLException {
		boolean flag = false;

		String string = "update appointment set status=? where id=? and doctorid=?";

		PreparedStatement pwPreparedStatement = connection.prepareStatement(string);

		pwPreparedStatement.setString(1, comm);
		pwPreparedStatement.setInt(2, id);
		pwPreparedStatement.setInt(3, did);

		int i = pwPreparedStatement.executeUpdate();

		if (i == 1) {

			flag = true;

		}
		return flag;

	}
	
	
	
	//admin pation.jsp use
	

	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment order by id asc";
			PreparedStatement ps = connection.prepareStatement(sql);
		

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullname(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoindate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhno(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorid(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


}

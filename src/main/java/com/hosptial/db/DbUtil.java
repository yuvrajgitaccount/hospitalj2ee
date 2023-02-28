package com.hosptial.db;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbUtil {

	private static Connection connection;

	public static Connection getConnection() {

		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp", "root", "yuvraj");

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return connection;

	}

}

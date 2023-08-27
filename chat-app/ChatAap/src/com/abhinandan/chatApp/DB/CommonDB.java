package com.abhinandan.chatApp.DB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import static com.abhinandan.chatApp.utils.ConfigReader.getValue;
//throw early and catch later
public interface CommonDB {
	public static Connection createConnection()throws ClassNotFoundException,SQLException {
		Class.forName(getValue("DRIVER"));
		final String CONNECTION_1=getValue("CONNECTION_UTL");
		final String User_ID=getValue("USERRID");
		final String PASSWORD=getValue("PASSWORD");
		Connection con=DriverManager.getConnection(CONNECTION_1,User_ID,PASSWORD);
		if(con !=null) {
			System.out.println("Connection created..........");
//			con.close();
		}return con;
	}
	
}

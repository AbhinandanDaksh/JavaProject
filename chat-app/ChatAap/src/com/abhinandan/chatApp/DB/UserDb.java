package com.abhinandan.chatApp.DB;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abhinandan.chatApp.dto.UserDTO;
import com.abhinandan.chatApp.utils.Encryption;

public class UserDb {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException,Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		final String SQL="select userId from user where userId=? and password=?";
		try {
			System.out.println("in user db");
			con=CommonDB.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,userDTO.getUserid());
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getUserid()));
			pstmt.setString(2,encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	
	
	 public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException,Exception{
		 System.out.print("rec"+userDTO.getUserid()+" "+userDTO.getPassword());
		 
		 Connection connection =null;
		 Statement stmt=null;//query
		 try {
		 connection =CommonDB.createConnection();
		 stmt=connection.createStatement();
		 int record=stmt.executeUpdate( "insert into user (userId,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");
		 return record;
		 }
		 finally {
			 if(stmt!=null) {
		 stmt.close();
			 }
			 if(connection!=null) {
		 connection.close();
		 }
		 }
	}

}

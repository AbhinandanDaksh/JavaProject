package com.abhinandan.chatApp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	 public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		 String encruptedPassword=null;
		 MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		 messageDigest.update(plainPassword.getBytes());
		 byte[] encrypt= messageDigest.digest();
//		 encruptedPassword=new String(encrypt);
		 StringBuffer sb=new StringBuffer();
		 for(byte b:encrypt) {
			 sb.append(b);
		 }
		 encruptedPassword=sb.toString();
//		 System.out.println("encruptedPassword"+encruptedPassword);
		 return encruptedPassword;
	 }
	 
}

package com.naztech.dbUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	// Connection er akta variable newa hoyeche than oitar instance ke null kora hoyeche
	public static Connection con;
	private static Connection instance=null;

	     public static void getConnection() {
	 
	         try {
	             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	             con = DriverManager.getConnection("jdbc:sqlserver://vNTDACWSSQLD002:1433; databaseName=DEV_TEST; user= dev_test_dbo; password = dev_test_dbo123");
	             
	             //Connection holo kina ta confirm howar jonno... na dileo chole
	        	 if(con != null) {
	        		 System.out.println("Connected");
	            	 //DatabaseMetaData metaObj = (DatabaseMetaData) con.getMetaData();
	            	 //System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
	             }
	 
	         } catch(Exception sqlException) {
	             sqlException.printStackTrace();
	         }
	     }
}     
	/*
	 private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 private String url="jdbc:sqlserver://vNTDACWSSQLD002:1433/DEV_TEST"; 
	 private String userName="dev_test_dbo";
	 private String password="dev_test_dbo123";
	  
	 public void loadDriver(String driv) throws ClassNotFoundException{
	 Class.forName(driver); 
	 } 
	 public Connection getConnection() throws ClassNotFoundException, SQLException{ 
	 loadDriver(driver); 
	 Connection con=DriverManager.getConnection(url,userName,password); 
	 return connection; 
	 }
	 */	    


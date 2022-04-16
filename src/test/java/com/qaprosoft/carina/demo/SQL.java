package com.qaprosoft.carina.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SQL {
@Test
	public void SQLserver() throws ClassNotFoundException, SQLException, InterruptedException {
		
		String userName = "qk_QAUSER";
	       String password = "t&:826EReld/*|05";
	       String url = "jdbc:sqlserver://10.139.186.188:8190;database=Partner_and_CustomerPortal_UAT;integratedSecurity=true;";
	       Connection con = DriverManager.getConnection(url, userName, password);
	          //Connection con = DriverManager.getConnection(""); 
	          Statement stmt = con.createStatement();
	            String SQL = "Select top 1 OtpCode,Mobile from OTPVerification where Mobile='7021620511' order by id desc";
	            //int rs = stmt.executeUpdate(SQL);
	            ResultSet rs = stmt.executeQuery(SQL);
	             while (rs.next()) {
	            	
	            	  System.out.print("MobileNumber: "+rs.getString("Mobile")+", ");
	                  System.out.print("OTPCode: "+rs.getString("OtpCode")+",");
	             
	               System.out.println();
	             }}
}
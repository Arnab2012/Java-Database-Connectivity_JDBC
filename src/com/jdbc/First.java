package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class First {
public static void main(String[]args){
		
		try{
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//create connection
			String url = "jdbc:oracle:thin:@localhost:1521:XE";

			Connection con=DriverManager.getConnection(url,"Arnab","arnab");

//			checking connection established or not
			if(con.isClosed()){
				System.out.println("Closed");
			}
			else{
				System.out.println("Success");
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

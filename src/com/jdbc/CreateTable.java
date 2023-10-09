package com.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateTable {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection con=DriverManager.getConnection(url,"Arnab","arnab");
			
			String q="create table Student(Name varchar(20),Roll number(5) primary key,marks number(4,2))";
			Statement stmt=con.createStatement();
			stmt.executeUpdate(q);
			
			System.out.println("Table created Successfully");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

package com.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test{
	public static void main(String[] args) throws Exception{
//		load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		create the Connection
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection con=DriverManager.getConnection(url,"Arnab","arnab");
		
//		create the query
		String q="Select * from Employee";
//		create Statement
		Statement st=con.createStatement();
//		ResultSet
		ResultSet rs=st.executeQuery(q);
		
//		execute the query
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
//		close the connection
		con.close();
	}
}
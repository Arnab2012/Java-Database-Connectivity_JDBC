package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Connection con=DriverManager.getConnection(url,usr,pwd);
		Statement st=con.createStatement();
		String q="insert into emp values(1,'Arnab')";
		
		int update_count=st.executeUpdate(q);
		System.out.println("Value Inserted Successfully");
		System.out.println("No of rows inserted--> "+update_count);
		
		con.close();
	}

}

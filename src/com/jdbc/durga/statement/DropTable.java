package com.jdbc.durga.statement;

import java.sql.*;

public class DropTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Connection con=DriverManager.getConnection(url,usr,pwd);
		Statement st=con.createStatement();
		String q="drop table emp";
		
		st.executeUpdate(q);
		System.out.println("Table Dropped Successfully");
		
		con.close();
	}

}

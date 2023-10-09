package com.jdbc.durga.statement;
import java.sql.*;

public class CreateTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
//		load and register driver
		Class.forName("oracle.jdbc.OracleDriver");
//		create connection
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="Arnab";
		String pwd="arnab";
		Connection con=DriverManager.getConnection(url,username,pwd);
		
//		Statement Object Creation
		Statement st=con.createStatement();
		
//		Query creation
		String q="create table emp(eno number(2), ename varchar2(10))";
//		execute Query
		st.executeUpdate(q);
		System.out.println("Table Created Successfully");
		
		con.close();
	}

}

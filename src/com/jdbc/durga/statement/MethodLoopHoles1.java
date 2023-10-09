package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MethodLoopHoles1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
//			here we are using executeQuery() for non-select operation
			String q="insert into emp values(7,'Sayani',20000)";
			ResultSet rs=st.executeQuery(q);
			
//			here we will get the exception
			while(rs.next()) {
				System.out.println("Hello");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

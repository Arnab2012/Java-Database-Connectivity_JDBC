package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MethodLoopHoles2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
//			here we are using executeUpdate() for select operation
			String q="select * from emp";
//			it will return no of rows selected
			int uc=st.executeUpdate(q);
			System.out.println(uc);
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
			String q="update emp set esal=esal+10";
			int c=st.executeUpdate(q);
			System.out.println(c+" no of rows Updated Successfully");
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

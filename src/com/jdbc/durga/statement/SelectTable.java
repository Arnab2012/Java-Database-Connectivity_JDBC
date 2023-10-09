package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
			String q="select * from emp";
			boolean flag=false;
			ResultSet rs=st.executeQuery(q);
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			if(flag==false) System.out.println("No rows matched");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
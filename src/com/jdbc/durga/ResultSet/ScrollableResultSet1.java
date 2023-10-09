package com.jdbc.durga.ResultSet;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ScrollableResultSet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement(1004,1008);
			String q="select * from emp";
			ResultSet rs=st.executeQuery(q);
			
			System.out.println("Forward Scroll-->");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			System.out.println();
			
			System.out.println("Backward Scroll-->");
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

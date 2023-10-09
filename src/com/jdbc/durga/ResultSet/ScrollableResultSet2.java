package com.jdbc.durga.ResultSet;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ScrollableResultSet2 {

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
			
//			move cursor to first row
			rs.first();
			System.out.println("Data at first row-->");
			System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			
			System.out.println();
			
//			move cursor to last row
			rs.last();
			System.out.println("Data at last row-->");
			System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			
			System.out.println();
//			move cursor to 2nd last row
			rs.relative(-1);
			System.out.println("Data at 2nd last row-->");
			System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			
			System.out.println();
//			move cursor to 2nd row
			rs.absolute(2);
			System.out.println("Data at 2nd row-->");
			System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

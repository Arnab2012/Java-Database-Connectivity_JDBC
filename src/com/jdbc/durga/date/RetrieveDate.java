package com.jdbc.durga.date;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class RetrieveDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			String query="select * from demo";
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			while(rs.next()) {
				String name=rs.getString(1);
				Date date=rs.getDate(2); // it will return yyyy-MM-dd format
				
				String s=sdf.format(date); // formatting date to required format
				System.out.println(name+" "+s);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

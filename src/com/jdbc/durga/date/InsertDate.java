package com.jdbc.durga.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			System.out.println("Enter name-->");
			String name=sc.next();
			System.out.println("Enter DOB-->");
			String date=sc.next();
			
			java.sql.Date sdate=java.sql.Date.valueOf(date);
			String query="insert into demo values(?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setDate(2, sdate); // here must provide java.sql.Date
			
			int rc=pst.executeUpdate();
			if(rc==0) System.out.println("Record not inserted");
			else System.out.println("Inserted");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}

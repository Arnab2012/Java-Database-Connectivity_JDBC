package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertTable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection con=DriverManager.getConnection(url,"Arnab","arnab");
			
			String q="insert into Student(Name,Roll,Marks) values(?,?,?)";
			
			
			int n;
			System.out.print("Enter the number of rows--> ");
			n=sc.nextInt();
			
			for(int i=0;i<n;i++) {
				System.out.print("Enter name--> ");
				String name=sc.next();
				System.out.print("Enter roll--> ");
				int roll=sc.nextInt();
				System.out.print("Enter marks--> ");
				double marks=sc.nextDouble();
				
//				PreparedStatement is used for dynamic query
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1,name);
				pstmt.setInt(2, roll);
				pstmt.setDouble(3, marks);
				
//				for dynamic query at the time of prepared statement we have to pass the query
				pstmt.executeUpdate();
			}
			
			System.out.println("All values Inserted Successfully...");
			con.close();
			sc.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

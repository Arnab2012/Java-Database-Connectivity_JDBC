package com.jdbc.durga.LOBs;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			System.out.println("Enter name-->");
			String name=sc.next();
			File f=new File("Nature.jpeg");
			System.out.println(f.getAbsolutePath());
			FileInputStream fis=new FileInputStream("C:\\\\Users\\\\arnab\\\\eclipse-workspace\\\\Jdbc01\\\\src\\\\com\\\\jdbc\\\\durga\\\\LOBs\\Nature.jpeg");
			String query="insert into Person values(?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setBinaryStream(2, fis);
			
			int rc=pst.executeUpdate();
			if(rc==0) System.out.println("Record not inserted");
			else System.out.println("Inserted");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();

	}

}

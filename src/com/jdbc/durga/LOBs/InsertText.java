package com.jdbc.durga.LOBs;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			String query="insert into Text values(?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			//String path="C:\\Users\\arnab\\eclipse-workspace\\Jdbc01\\src\\com\\jdbc\\durga\\LOBs";
			File f=new File("test.txt");
			System.out.println(f.getAbsolutePath());
			
			FileReader fr=new FileReader("C:\\Users\\arnab\\eclipse-workspace\\Jdbc01\\src\\com\\jdbc\\durga\\LOBs\\test.txt");
			pst.setString(1, "test");
			pst.setCharacterStream(2, fr);
			
			int rc=pst.executeUpdate();
			if(rc==0) System.out.println("Record not inserted");
			else System.out.println("Inserted");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();

	}

}

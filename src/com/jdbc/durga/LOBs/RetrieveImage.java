package com.jdbc.durga.LOBs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			String query="select * from Person";
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			FileOutputStream os=new FileOutputStream("Nature1.jpg");
			if(rs.next()) {
				String name=rs.getString(1);
				InputStream is=rs.getBinaryStream(2);
				byte[] buffer=new byte[2048];
				while(is.read(buffer)>0) {
					os.write(buffer);
				}
				os.flush();
				System.out.println("Image is avialable is -> Nature1.jpeg");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();


	}

}

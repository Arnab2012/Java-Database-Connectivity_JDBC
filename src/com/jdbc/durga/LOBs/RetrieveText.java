package com.jdbc.durga.LOBs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			String query="select * from Text";
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			FileWriter fw=new FileWriter("Output.txt");
			if(rs.next()) {
				String name=rs.getString(1);
				Reader r=rs.getCharacterStream(2);
				int i=r.read();
				while(i!=-1) {
					fw.write(i);
					i=r.read();
				}
				fw.flush();
				System.out.println("File is avialable is -> Output.txt");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();


	}

}

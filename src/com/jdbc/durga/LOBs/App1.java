// table--> create table jobseeker(name varchar(20),dob date,image blob, resume clob);
package com.jdbc.durga.LOBs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
//			inserting name and dob
			System.out.println("Enter name--> ");
			String name=sc.next();
			System.out.println("Enter dob(yyyy-MM-dd)--> ");
			String date=sc.next();
			
			java.sql.Date sdate=java.sql.Date.valueOf(date);
			
//			insert image(BLOB)
			File f1=new File("Profile.jpeg");
			FileInputStream fis=new FileInputStream("C:\\Users\\arnab\\eclipse-workspace\\Jdbc01\\Passport.jpeg");
			
//			insert resume(CLOB)
			File f2=new File("Resume.pdf");
			FileReader fr=new FileReader("C:\\Users\\arnab\\eclipse-workspace\\Jdbc01\\Resume.pdf");
			
//			query creation
			String query="insert into jobseeker values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			
//			setting values
			pst.setString(1, name);
			pst.setDate(2, sdate);
			pst.setBinaryStream(3, fis);
			pst.setCharacterStream(4, fr);
			
//			execute query
			int rc=pst.executeUpdate();
			if(rc==0) System.out.println("Record not inserted");
			else System.out.println("Record inserted");
			
//			write date
			String query1="select * from jobseeker";
			PreparedStatement pst1=con.prepareStatement(query1);
			
			ResultSet rs=pst1.executeQuery();
			
			FileOutputStream os=new FileOutputStream("Profile.jpg");
			FileWriter fw=new FileWriter("Demo.pdf");
			while(rs.next()) {
//				get Name
				String n=rs.getString(1);
//				get Date
				Date d=rs.getDate(2);
//				get Image
				InputStream is=rs.getBinaryStream(3);
				byte[] buffer=new byte[2048];
				while(is.read(buffer)>0) {
					os.write(buffer);
				}
				os.flush();
				
//				get file
				Reader r=rs.getCharacterStream(4);
				int i=r.read();
				while(i!=-1) {
					fw.write(i);
					i=r.read();
				}
				fw.flush();
				
				System.out.println(n);
				System.out.println(d);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}

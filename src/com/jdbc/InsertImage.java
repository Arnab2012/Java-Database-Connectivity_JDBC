package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InsertImage {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection con=DriverManager.getConnection(url,"Arnab","arnab");
//			String q="create table Images(id number(3) primary key,image blob)";
//			Statement stmt=con.createStatement();
//			stmt.executeUpdate(q);
			System.out.println("Table Created");
			
			String q="Insert into Images(id,image) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			JFileChooser jfc=new JFileChooser();
//			dialogbox at center
			jfc.showOpenDialog(null);
			File file=jfc.getSelectedFile();
			
//			FileInputStream fis=new FileInputStream("C:\\Users\\arnab\\eclipse-workspace\\Jdbc01\\src\\com\\jdbc\\Image.jpeg");
			FileInputStream fis=new FileInputStream(file);
			
			pstmt.setInt(1, 1);
//			to insert the image
			pstmt.setBinaryStream(2, fis,fis.available());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Success");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

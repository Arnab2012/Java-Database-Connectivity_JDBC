package com.jdbc.durga.pst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDynamic {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Connection con=DriverManager.getConnection(url,usr,pwd);
		
//		dynamic query creation
		String q="insert into emp values(?,?,?)";
//		here it will one time compile the code and return the pre-compiled code
		PreparedStatement pst=con.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter eno--> ");
			int eno=sc.nextInt();
			System.out.println("Enter ename--> ");
			String ename=sc.next();
			System.out.println("Enter esal--> ");
			int esal=sc.nextInt();
			
//			set dynamic inputs
			pst.setInt(1,eno);
			pst.setString(2,ename);
			pst.setInt(3,esal);
			
//			here just execution not compilation
			pst.executeUpdate();
			System.out.println("Row inserted Successfully");
			System.out.println("Want to insert again? ");
			String choice=sc.next();
			if(choice.equalsIgnoreCase("No")) {
				break;
			}
		}
		System.out.println("Done");
		con.close();
		sc.close();
	}

}

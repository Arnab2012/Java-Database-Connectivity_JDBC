package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTableDynamic {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Connection con=DriverManager.getConnection(url,usr,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter eno--> ");
			int eno=sc.nextInt();
			System.out.println("Enter ename--> ");
			String ename=sc.next();
			System.out.println("Enter esal--> ");
			int esal=sc.nextInt();
			
			String q=String.format("insert into emp values(%d,'%s',%d)",eno,ename,esal);
			int count=st.executeUpdate(q);
			System.out.println("Row inserted Successfully");
			System.out.println("No of rows inserted--> "+count);
			
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

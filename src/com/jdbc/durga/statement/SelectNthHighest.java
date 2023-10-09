package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNthHighest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
			System.out.println("Enter the value of N--> ");
			int N=sc.nextInt();
			boolean flag=false;
			String q=String.format("select * from emp e1 where %d-1=(select count(distinct esal) from emp e2 where e2.esal>e1.esal)",N);
			ResultSet rs=st.executeQuery(q);
			while(rs.next()) {
				flag=true;
				System.out.println("Info of "+N+"th Highest Salary--> ");
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			if(flag==false) { 
				System.out.println("no rows selected");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}

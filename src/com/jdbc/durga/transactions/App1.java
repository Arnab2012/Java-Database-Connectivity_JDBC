package com.jdbc.durga.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		Scanner sc=new Scanner(System.in);
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
			String q1="select * from accounts";
			ResultSet rs=st.executeQuery(q1);
			
			System.out.println("Data before Transaction--> ");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getInt(2));
			}
			
//			Transaction start
			System.out.println("Transaction begins-->");
//			turn off autoCommit
			con.setAutoCommit(false);
			
			String q2="update accounts set balance=balance-5000 where name='Ayan'";
			st.executeUpdate(q2);
			String q3="update accounts set balance=balance+5000 where name='Arnab'";
			st.executeUpdate(q3);
			
//			here transaction completed
			System.out.println("Do you confirm the transaction--> ");
			String choice=sc.next();
			if(choice.equalsIgnoreCase("yes")) {
//				then commit all the previous transactions
				con.commit();
			}
			else con.rollback();
			
//			after transaction
			String q4="select * from accounts";
			ResultSet rs1=st.executeQuery(q4);
			
			System.out.println("Data before Transaction--> ");
			while(rs1.next()) {
				System.out.println(rs1.getString(1)+" "+rs1.getInt(2));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}

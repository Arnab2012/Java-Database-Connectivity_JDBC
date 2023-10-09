package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aggregate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			Statement st=con.createStatement();
			String q1="select count(*) from emp";
			ResultSet rs=st.executeQuery(q1);
			if(rs.next()) {
				int n=rs.getInt(1);
				System.out.println("No of rows--> "+n);
				String q2="select max(esal) from emp";
				rs=st.executeQuery(q2);
				if(rs.next()) {
					int max=rs.getInt(1);
					System.out.println("Max salary is--> "+max);
				}
				String q3="select min(esal) from emp";
				rs=st.executeQuery(q3);
				if(rs.next()) {
					int min=rs.getInt(1);
					System.out.println("Min salary is--> "+min);
				}
				String q4="select avg(esal) from emp";
				rs=st.executeQuery(q4);
				if(rs.next()) {
					int avg=rs.getInt(1);
					System.out.println("Avgsalary is--> "+avg);
				}
			}
			else {
				System.out.println("No rows in the table!!");
			}
		}catch(Exception e) {
			System.out.println(e);
		}


	}

}

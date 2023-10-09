package com.jdbc.durga.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aggregate1 {

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
				int c=0,sal=10000;
				for(int i=1;i<=n;i++) {
					Statement st1=con.createStatement();
					String q=String.format("update emp set esal=%d where eno=%d",sal,i);
					c+=st1.executeUpdate(q);
					sal=sal*2;
				}
				System.out.println(c+" no of rows Updated Successfully");
			}
			else {
				System.out.println("No rows to be updated");
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

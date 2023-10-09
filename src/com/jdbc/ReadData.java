package com.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ReadData {

	public static void main(String[] args) {
		try{
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//create connection
			String url = "jdbc:oracle:thin:@localhost:1521:XE";

			Connection con=DriverManager.getConnection(url,"Arnab","arnab");

//			Query Creation
			String q="Select * from Employee";
			Statement stmt=con.createStatement();
			
			ResultSet set= stmt.executeQuery(q);
			
//			Process the Data
			while (set.next()) {
                String eno = set.getString("ENO");
                String ename = set.getString("ENAME");
                String dept = set.getString("DEPT");
                int age = set.getInt("AGE");

                System.out.println("Employee Number: " + eno);
                System.out.println("Employee Name: " + ename);
                System.out.println("Department: " + dept);
                System.out.println("Age: " + age);
                System.out.println("------------------------");
            }
			
//			Close the resources
            set.close();
            stmt.close();
            con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

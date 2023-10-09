package com.jdbc.durga.ResultSet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class CheckSupport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println(dbmd.supportsResultSetConcurrency(1003, 1007));
			System.out.println(dbmd.supportsResultSetConcurrency(1003, 1008));
			
			System.out.println(dbmd.supportsResultSetType(1003));
			System.out.println(dbmd.supportsResultSetType(1004));
			System.out.println(dbmd.supportsResultSetType(1005));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

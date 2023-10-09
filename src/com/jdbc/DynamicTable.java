package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicTable {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
//			load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			create Connection
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			System.out.println("Enter Username--> ");
			String user=sc.next();
			System.out.println("Enter Password--> ");
			String pass=sc.next();
			Connection con=DriverManager.getConnection(url,user,pass);
			
//			checking the connection
			if(con.isClosed()) {
				System.out.println("Error in Connection!!!");
			}
			else {
				System.out.println("Connected Successfully");
			}
			
//			getting input for table creation
			System.out.print("\nEnter the table Name--> ");
			String tableName=sc.next();
			System.out.println("Enter the no of columns--> ");
			int noOfColumns=sc.nextInt();
			sc.nextLine();
			
//			for columnName,type and their size
			String[]columnName=new String[noOfColumns];
			String[]columnType=new String[noOfColumns];
			int[]columnSize=new int[noOfColumns];
			
//			getting input for column details
			for(int i=0;i<noOfColumns;i++) {
				System.out.printf("\nEnter Details for Column %d-->\n",i+1);
				System.out.print("Name: ");
				columnName[i]=sc.nextLine();
				System.out.print("Type: ");
				columnType[i]=sc.nextLine();
				System.out.print("Size: ");
				columnSize[i]=sc.nextInt();
				sc.nextLine();
			}
			
//			create table
			createTable(con,tableName,columnName,columnType,columnSize);
			
//			insert into table
			insertIntoTable(con, tableName, columnName, columnType, noOfColumns, sc);

			System.out.println("All values Inserted Successfully...");
			con.close();
			sc.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertIntoTable(Connection con, String tableName, String[] columnName, String[] columnType,
			int noOfColumns, Scanner sc) throws SQLException {
//		insert into query creation
		StringBuilder insert=new StringBuilder();
		insert.append("Insert into ").append(tableName).append("(");
		for(int i=0;i<noOfColumns;i++) {
			insert.append(columnName[i]);
			if(i!=noOfColumns-1) {
				insert.append(",");
			}
		}
		insert.append(") values (");
		for(int i=0;i<noOfColumns;i++) {
			insert.append("?");
			if(i!=noOfColumns-1) {
				insert.append(",");
			}
		}
		insert.append(")");
		
		String q1=insert.toString();

//		getting input for insert values
		int row;
		System.out.print("\nEnter the number of rows you want to insert--> ");
		row=sc.nextInt();
		
		for (int i = 0; i < row; i++) {
		    System.out.printf("\nEnter Details for Row %d-->\n", i + 1);

		    PreparedStatement pstmt = con.prepareStatement(q1);
		    for(int j=0;j<noOfColumns;j++) {
		    	System.out.print(columnName[j] + " : ");
		    	String columnValue=sc.next();
		    	if (columnType[j].equalsIgnoreCase("number")) {
		            pstmt.setInt(j + 1, Integer.parseInt(columnValue));
		        }  else if (columnType[j].equalsIgnoreCase("varchar")) {
		            pstmt.setString(j + 1,columnValue);
		        }
		    }

		    pstmt.executeUpdate();
		}
		
	}

	private static void createTable(Connection con, String tableName, String[] columnName, String[] columnType,
			int[] columnSize) throws SQLException {
//		create table query creation
		StringBuilder create=new StringBuilder();
		create.append("create table ").append(tableName).append("(");
		for(int i=0;i<columnName.length;i++) {
			create.append(columnName[i]+" "+columnType[i]+"("+columnSize[i]+")");
			if(i!=columnName.length-1) {
				create.append(",");
			}
		}
		create.append(")");
		
		
//		create table query execute
		String q=create.toString();
		Statement stmt=con.createStatement();
		stmt.executeUpdate(q);
		
		System.out.println(tableName+" created Successfully in the database");
		
		
	}

}

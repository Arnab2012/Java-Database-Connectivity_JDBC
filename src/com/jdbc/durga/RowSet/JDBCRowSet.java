package com.jdbc.durga.RowSet;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSet {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		
//		RowSetFactory object creation
		RowSetFactory rsf=RowSetProvider.newFactory();
		
//		JdbcRowSet
		JdbcRowSet rs=rsf.createJdbcRowSet();
		
//		setting connection
		rs.setUrl(url);
		rs.setUsername(usr);
		rs.setPassword(pwd);
		
//		query execution
		rs.setCommand("select * from emp");
		rs.execute();

		System.out.println("Forward Scroll-->");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		System.out.println();
		
		System.out.println("Backward Scroll-->");
		while(rs.previous()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		System.out.println();
		
//		move cursor to first row
		rs.first();
		System.out.println("Data at first row-->");
		System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
		System.out.println();
		
//		move cursor to last row
		rs.last();
		System.out.println("Data at last row-->");
		System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
		System.out.println();
//		move cursor to 2nd last row
		rs.relative(-1);
		System.out.println("Data at 2nd last row-->");
		System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
		System.out.println();
//		move cursor to 2nd row
		rs.absolute(2);
		System.out.println("Data at 2nd row-->");
		System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		
	}

}

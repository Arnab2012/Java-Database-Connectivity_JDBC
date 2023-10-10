package com.jdbc.durga.RowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class RowSet1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		RowSet object creation
		RowSetFactory rs=RowSetProvider.newFactory();	
		JdbcRowSet jrs=rs.createJdbcRowSet();
		CachedRowSet crs=rs.createCachedRowSet();
		JoinRowSet jors=rs.createJoinRowSet();
		WebRowSet wrs=rs.createWebRowSet();
		FilteredRowSet frs=rs.createFilteredRowSet();
		
		System.out.println(jrs.getClass().getName());
		System.out.println(crs.getClass().getName());
		System.out.println(jors.getClass().getName());
		System.out.println(wrs.getClass().getName());
		System.out.println(frs.getClass().getName());
		
	}

}

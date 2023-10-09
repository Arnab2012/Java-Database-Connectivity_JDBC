package com.jdbc.durga.date;

public class ConvertDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date udate=new java.util.Date();
		System.out.println(udate); // both date and time format
//		get Time
		long l=udate.getTime();
//		convert util Date to sql Date
		java.sql.Date sdate=new java.sql.Date(l);
		System.out.println(sdate); // only date (yyyy-MM-dd)

	}

}

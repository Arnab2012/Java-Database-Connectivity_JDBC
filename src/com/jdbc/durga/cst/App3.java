//Stored Procedure
//create or replace Procedure getNameDept(eno1 in varchar,ename1 out varchar,dept1 out varchar)as
//begin
//	select ename,dept into ename1,dept1 from employee where eno=eno1;
//end;
///
package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			CallableStatement cst=con.prepareCall("{call getNameDept(?,?,?)}");
			cst.setString(1,"E15");
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.execute();
			System.out.println("Name--> "+cst.getString(2));
			System.out.println("Dept--> "+cst.getString(3));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

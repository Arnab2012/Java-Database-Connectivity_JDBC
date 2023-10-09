//Stored Procedure
//create or replace Procedure getSal(eno1 in number,esal1 out number)as
//begin
//	select esal into esal1 from emp where eno=eno1;
//end;
///
package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			CallableStatement cst=con.prepareCall("{call getSal(?,?)}");
			cst.setInt(1, 3);
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
			int result=cst.getInt(2);
			System.out.println(result);
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

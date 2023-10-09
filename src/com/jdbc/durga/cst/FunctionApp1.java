//Function-->
//create or replace function getAvg(id1 In number,id2 In number)return number as
//sal1 number;
//sal2 number;
//begin
//select esal into sal1 from emp where eno=id1;
//select esal into sal2 from emp where eno=id2;
//return (sal1+sal2)/2;
//end;
///
package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			CallableStatement cst=con.prepareCall("{?=call getAvg(?,?)}");
			cst.setInt(2, 1);
			cst.setInt(3, 10);
//			register out parameter
			cst.registerOutParameter(1, Types.FLOAT);
			cst.execute();
			System.out.println(cst.getFloat(1));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

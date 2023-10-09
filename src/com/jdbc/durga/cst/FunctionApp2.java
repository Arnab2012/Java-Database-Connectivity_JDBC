//Function-->
//create or replace function getInfo(id1 In number)return SYS_REFCURSOR as
//emps SYS_REFCURSOR;
//begin
//open emps for
//select * from emp where eno=id1;
//return emps;
//end;
///
package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

public class FunctionApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			CallableStatement cst=con.prepareCall("{?=call getInfo(?)}");
			cst.setInt(2, 10);
//			register out parameter
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			boolean flag=false;
			ResultSet rs=(ResultSet)cst.getObject(1);
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			if(flag==false) System.out.println("No rows matched");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

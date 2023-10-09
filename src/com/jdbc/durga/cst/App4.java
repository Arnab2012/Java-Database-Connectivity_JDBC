//Stored Procedure
//create or replace Procedure getNameDept(eno1 in varchar,emps out SYS_REFCURSOR)as
//begin
//	open emps for
//	select * from employee where eno=eno1;
//end;
///
package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import oracle.jdbc.*;

public class App4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
			CallableStatement cst=con.prepareCall("{call getNameDept(?,?)}");
			cst.setString(1,"E100");
			cst.registerOutParameter(2,OracleTypes.CURSOR);
			cst.execute();
			boolean flag=false;
			ResultSet rs=(ResultSet)cst.getObject(2);
			while(rs.next()) {
				flag=true;
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
			if(flag==false) System.out.println("No rows matched");
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

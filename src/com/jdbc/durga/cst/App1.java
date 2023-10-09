//Stored Procedure
//create or replace Procedure addproc(X in number,Y in number,Z out number)as
//begin
//	Z:=X+Y;
//end;
///

package com.jdbc.durga.cst;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String usr="Arnab";
		String pwd="arnab";
		try(Connection con=DriverManager.getConnection(url,usr,pwd)){
//			creation of CallableStatement Object
			CallableStatement cst=con.prepareCall("{call addProc(?,?,?)}");
//			set IN parameters
			cst.setInt(1,100);
			cst.setInt(2,200);
//			register OUT Parameter
			cst.registerOutParameter(3, Types.INTEGER);
//			execute
			cst.execute();
			
//			get result
			int ans=cst.getInt(3);
			System.out.println(ans);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
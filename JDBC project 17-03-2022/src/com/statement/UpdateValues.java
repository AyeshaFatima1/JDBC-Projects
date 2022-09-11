package com.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateValues {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost/db1"+ "","root","ayesha@7890");
		Statement stm=con.createStatement();
		
		String sql="update emp set firstname='Sana' where eid=345";
		stm.executeUpdate(sql);
		sql="update emp set lastname='Khan' where firstname='Sana'";
		stm.executeUpdate(sql);

		System.out.println("values are updated....");
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
	}

}

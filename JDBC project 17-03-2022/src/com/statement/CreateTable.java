package com.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			Statement stmt=conn.createStatement();
			String sql="CREATE TABLE EMP"+"(eid INTEGER not NULL,"+"firstname VARCHAR(255),"
					+"lastname VARCHAR(255),"+"age INTEGER,"+"PRIMARY KEY(eid))";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database....");
		}
      catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}

package com.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Rollback {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement();
			
			String query1="insert into EMP(eid,firstname,lastname,age)values(340,'Hafsa','Fatima',20)";
		    String query2="insert into EMP(eid,firstname,lastname,age)values(390,'Sasa','Khan',20)";
		    stmt.executeUpdate(query1);
		    stmt.executeUpdate(query2);
		
		    conn.commit();
		System.out.println("Row is inserted");
		}
		catch(Exception e) {
		try {
			conn.rollback();
		}
			catch(SQLException e1) {
			e1.printStackTrace();	
			}
         System.out.println("Transaction failed!...");
         e.printStackTrace();
         }
	}
}

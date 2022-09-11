package com.preparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedInsert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
			PreparedStatement pstmt=conn.prepareStatement("insert into emp values(?,?,?,?)");
			pstmt.setInt(1,367);//1 specifies the first parameter in the query
			pstmt.setString(2,"Ayesha");
			pstmt.setString(3,"Fatima");
			pstmt.setInt(4, 22);
			
		    pstmt=conn.prepareStatement("insert into emp values(?,?,?,?)");
			pstmt.setInt(1,324);
			pstmt.setString(2,"Sana");
			pstmt.setString(3,"Fatima");
			pstmt.setInt(4, 23);
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"records inserted");
			
			
				}
      catch(Exception e) {
    	  System.out.println("records are inserted");
      }
   	}

}



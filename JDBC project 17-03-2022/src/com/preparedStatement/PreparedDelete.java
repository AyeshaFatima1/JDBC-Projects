package com.preparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedDelete {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
			PreparedStatement pstmt=conn.prepareStatement("delete from emp where firstname=? ");
			
			pstmt.setString(1,"Ayesha");
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"records deleted");
			
			
				}
      catch(Exception e) {
    	  e.printStackTrace();
      }
   	}

}



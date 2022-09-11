package com.preparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedScanner {


	public static void main(String[] args ) throws Exception{
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
		    PreparedStatement pstmt=conn.prepareStatement("insert into emp values(?,?,?,?)");
			Scanner sc=new Scanner(System.in);
		    
			do {
			System.out.println("Enter id:");
			int eid = 0;
			pstmt.setInt(1, eid);
			eid=sc.nextInt();
			
			System.out.println("Enter firstname:");
			String firstname =null;
			pstmt.setString(2,firstname);
		    firstname=sc.next();
			
		    System.out.println("Enter lastname:");
			String lastname = null;
			pstmt.setString(3,lastname);
			lastname=sc.next();
			
			System.out.println("Enter age:");
			int age = 0;
			pstmt.setInt(4, age);
			age=sc.nextInt();
			
		int i=pstmt.executeUpdate();
		System.out.println(i+"records");
		System.out.println("Do you want o continue: yes/no");
		String s=sc.nextLine();
		}
			while(true);
		}
		
}

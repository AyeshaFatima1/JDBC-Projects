package com.menudriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu2 
{
	String learner;
	
    public static void main( String[] args )
    {
        int id,age;
        String name,course,address;
    	String sql;
    	Connection con=null;
    	Statement stm=null;
    	PreparedStatement pstmt=null;
       	ResultSet rs=null;
       
    	Scanner sc=new Scanner(System.in);
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			System.out.println("Succesfully database is connected");
			System.out.println("==============================");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
   		int operation;
		do {
    		System.out.println("Enter your option:\n");
    		System.out.println("1.create table");
    		System.out.println("2.insert values into table");
    		System.out.println("3.update values");
    		System.out.println("4.delete values");
    		System.out.println("5.display table");
    		System.out.println("6.search element by id");
    		System.out.println("7.commit");
    		System.out.println("8.rollback");
    		System.out.println("9.exit");
    		System.out.println("--------------------------------");
    		
    		operation=sc.nextInt();
    		
   			switch(operation) {
    		
       		case 2:
    			System.out.println("Enter lid: ");
    			id=sc.nextInt();
    			System.out.println("Enter lname: ");
    			name=sc.next();
    			System.out.println("Enter lage: ");
    			age=sc.nextInt();
    			System.out.println("Enter lcourse: ");
    			course=sc.next();
    			System.out.println("Enter laddress: ");
    			address=sc.next();
    			try {
    			pstmt=con.prepareStatement("insert into learner values(?,?,?,?,?)");
    			pstmt.setInt(1,id);
    			pstmt.setString(2,name);
				pstmt.setInt(3,age);
    			pstmt.setString(4,course);
    			pstmt.setString(5,address);
    			
    			pstmt.executeUpdate();
    			System.out.println("records inserted");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 3:
    			try {
    			System.out.println("Enter lname:");
    			name=sc.next();
    			System.out.println("Enter lid:");
    			id=sc.nextInt();
   				pstmt=con.prepareStatement("update learner set lname=? where lid=? ");
             	pstmt.setString(1,name);
             	pstmt.setInt(2,id);
    		    pstmt.executeUpdate();
    		    System.out.println("values updated");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 4:
    			System.out.println("Enter lid:");
    			id=sc.nextInt();
    			try {
    			pstmt=con.prepareStatement("delete from learner where lid=? ");
    			pstmt.setInt(1,id);
    			pstmt.executeUpdate();
    			System.out.println("Record deleted");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 5:
    			try {
    			pstmt=con.prepareStatement("select*from learner");
    			rs=pstmt.executeQuery();
    			while(rs.next()) {
    		    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
    			}
    			System.out.println("values are selected");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 6:
    			System.out.println("Enter lid:");
    			sc.nextInt();
    			try {
        		pstmt=con.prepareStatement("select*from learner where lid=? ");
        		rs=pstmt.executeQuery();
        		while(rs.next()) {
        		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(3)+"\t"+rs.getString(5));	
        		}
        		System.out.println("value is selected");
        		}
       			catch(Exception e) {
       				e.printStackTrace();
                }
    			break;
    		case 7:
    			System.out.println("Enter lid:");
    			id=sc.nextInt();
    			System.out.println("Enter lname:");
    			name=sc.next();
    			System.out.println("Enter lage:");
    			age=sc.nextInt();
    			System.out.println("Enter lcourse:");
    			course=sc.next();
    			System.out.println("Enter laddress:");
    			address=sc.next();
    			try {
    			con.setAutoCommit(false);
    			pstmt=con.prepareStatement("insert into learner values(?,?,?,?,?)");
    			pstmt.setInt(1,id);		
				pstmt.setString(2,name);
			    pstmt.setInt(3,age);
			    pstmt.setString(4,course);
			    pstmt.setString(5, address);
    			pstmt.executeUpdate();
    			con.commit();
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 8:
    			try {
    			System.out.println("Enter lid:");
    			sc.nextInt();
    			System.out.println("Enter lname:");
    			sc.next();
    			System.out.println("Enter lage:");
    			sc.nextInt();
    			System.out.println("Enter lcourse:");
    			sc.next();
    			System.out.println("Enter laddress:");
    			sc.next();
    			con.setAutoCommit(false);
    			pstmt=con.prepareStatement("insert into learner values(?,?,?,?,?)");
    			pstmt.executeUpdate();
    			con.commit();
    			}
                catch(Exception e) {
                try {
                	con.rollback();
                }
                catch(SQLException e1) {
                e1.printStackTrace();
                }
                System.out.println("Transaction failed!.......");
                }
    			break;
    		case 9:
    			System.out.println("Exit");
    			break;
    		default:
    			System.out.println("select valid operations.....");
    			break;
    		}
    	}
    		while(operation!=9);
    			System.out.println("------------------");
    			
    }
   }




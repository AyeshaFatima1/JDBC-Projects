package com.menudriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu 
{
	String learner;
	
    public static void main( String[] args )
    {
       	String sql;
    	Connection con=null;
    	Statement stmt=null;
       	ResultSet rs=null;
       
    	Scanner sc=new Scanner(System.in);
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/dbMenudriven","root","ayesha@7890");
			System.out.println("Succesfully database connected");
			System.out.println("==============================");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	while(true) {
    		
    		System.out.println("Enter your option:\n");
    		System.out.println("1.insert values into table");
    		System.out.println("2.update values");
    		System.out.println("3.delete values");
    		System.out.println("4.display table");
    		System.out.println("5.search element by id");
    		System.out.println("6.commit");
    		System.out.println("7.rollback");
    		System.out.println("8.count learner");
    		System.out.println("9.minimum age");
    		System.out.println("10.maximum age");
    		System.out.println("11.avg");
    		System.out.println("12.sum");
    		System.out.println("13.exit");
    		System.out.println("******************************************");
    		int operation=sc.nextInt();
	
    		switch(operation) {
    		
       		case 1:
    			System.out.println("Enter lid: ");
    			int lid=sc.nextInt();
    			System.out.println("Enter lname: ");
    			String lname=sc.next();
    			System.out.println("Enter lage: ");
    			int lage=sc.nextInt();
    			System.out.println("Enter lcourse: ");
    			String lcourse=sc.next();
    			System.out.println("Enter lcity: ");
    			String lcity=sc.next();
    			try {
    			stmt=con.createStatement();
    			sql="insert into learner(lid,lname,lage,lcourse,lcity)values("+lid+",'"+lname+"',"+lage+",'"+lcourse+"','"+lcity+"')";
    			stmt.executeUpdate(sql);
    			System.out.println("*********************");
    			System.out.println("records inserted");
    			System.out.println("*********************");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 2:
    			try {
    			System.out.println("Enter lname:");
    			lname=sc.next();
    			System.out.println("Enter lid:");
    			lid=sc.nextInt();
   				stmt=con.createStatement();
             	sql="update learner set lname='"+lname+"' where lid="+lid+" ";
    		    stmt.executeUpdate(sql);
    		    System.out.println("**********************");
    		    System.out.println("value is updated");
    		    System.out.println("**********************");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 3:
    			System.out.println("Enter lid:");
    			lid=sc.nextInt();
    			try {
    			stmt=con.createStatement();
    			sql="delete from learner where lid="+lid+"";
    			stmt.executeUpdate(sql);
    			System.out.println("**********************");
    			System.out.println("Record is deleted");
    			System.out.println("**********************");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 4:
    			try {
    			stmt=con.createStatement();
    			sql="select*from learner";
    			rs=stmt.executeQuery(sql);
    			while(rs.next()) {
    			System.out.println("*****************************************");
    			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
       	        System.out.println("*****************************************");
    			}
    			System.out.println("values are selected");
    			System.out.println("-------------------");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 5:
    			System.out.println("Enter lid:");
    			lid=sc.nextInt();
    			try {
        		stmt=con.createStatement();
        		sql="select*from learner where lid="+lid+" ";
        		rs=stmt.executeQuery(sql);
        		while(rs.next()) {
        		System.out.println("***************************************");
        		System.out.print(rs.getInt(1)+"\t");
        		System.out.print(rs.getString(2)+"\t");
        		System.out.print(rs.getInt(3)+"\t");
        		System.out.print(rs.getString(4)+"\t");
        		System.out.println(rs.getString(5));
        		System.out.println("****************************************");
        		//System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getString(4)+rs.getString(5));
        		}
        		}
       			catch(Exception e) {
            		e.printStackTrace();
       			}
    			break;
    		case 6:
    			System.out.println("Enter lid: ");
    			lid=sc.nextInt();
    			System.out.println("Enter lname: ");
    			lname=sc.next();
    			System.out.println("Enter lage: ");
    			lage=sc.nextInt();
    			System.out.println("Enter lcourse: ");
    			lcourse=sc.next();
    			System.out.println("Enter lcity: ");
    			lcity=sc.next();
    			try {
    			con.setAutoCommit(false);
    			stmt=con.createStatement();
    			sql="insert into learner(lid,lname,lage,lcourse,lcity)values("+lid+",'"+lname+"',"+lage+",'"+lcourse+"','"+lcity+"')";
    			stmt.executeUpdate(sql);
    			con.commit();
    			System.out.println("Record inserted");
    			}
    			catch(Exception e) {
    				e.printStackTrace();
    			}
    			break;
    		case 7:
    			try {
    			System.out.println("Enter lid: ");
        		lid=sc.nextInt();
        		System.out.println("Enter lname: ");
       			lname=sc.next();
       			System.out.println("Enter lage: ");
       			lage=sc.nextInt();
       			System.out.println("Enter lcourse: ");
       			lcourse=sc.next();
       			System.out.println("Enter lcity: ");
       			lcity=sc.next();
    			con.setAutoCommit(false);
    			stmt=con.createStatement();
    			sql="insert into learner(lid,lname,lage,lcourse,lcity)values("+lid+",'"+lname+"',"+lage+",'"+lcourse+"','"+lcity+"')";
    			stmt.executeUpdate(sql);
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
    		case 8:
        			try {
            		stmt=con.createStatement();
            		sql="select count(*)from learner";
            		rs=stmt.executeQuery(sql);
            		rs.next();
            	      int count = rs.getInt(1);
            		System.out.println(count);
            		System.out.println("-------------------------");
        			}
        			catch(Exception e) {
        				e.printStackTrace();	
        			}
        			break;
    		case 9:
    			try {
            		stmt=con.createStatement();
            		sql="select min(lage)from learner";
            		rs=stmt.executeQuery(sql);
            		rs.next();
            	      int min = rs.getInt(1);
            		System.out.println(min);
            		System.out.println("-------------------------");
        			}
        			catch(Exception e) {
        				e.printStackTrace();	
        			}
        			break;
    		case 10:
    			try {
            		stmt=con.createStatement();
            		sql="select max(lage)from learner";
            		rs=stmt.executeQuery(sql);
            		rs.next();
            	      int max = rs.getInt(1);
            		System.out.println(max);
            		System.out.println("-------------------------");
        			}
        			catch(Exception e) {
        				e.printStackTrace();	
        			}
        			break;
    		case 11:
    			try {
            		stmt=con.createStatement();
            		sql="select avg(lage)from learner";
            		rs=stmt.executeQuery(sql);
            		rs.next();
            	      int avg = rs.getInt(1);
            		System.out.println(avg);
            		System.out.println("-------------------------");
        			}
        			catch(Exception e) {
        				e.printStackTrace();
        			}
        			break;
    		case 12:
    			try {
            		stmt=con.createStatement();
            		sql="select sum(lage)from learner";
            		rs=stmt.executeQuery(sql);
            		rs.next();
            	      int sum = rs.getInt(1);
            		System.out.println(sum);
            		System.out.println("-------------------------");
        			}
        			catch(Exception e) {
        			    e.printStackTrace();	
        			}
        			break;
    		case 13:
    			System.out.println("Exit");
                System.exit(0);
    		default:
    			System.out.println("select valid operations.....");
    			break;
    }
  }
 } 
}


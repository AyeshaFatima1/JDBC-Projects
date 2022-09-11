import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Commit {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement();
			
		//String sql="insert into EMP(eid,firstname,lastname,age)values(8,'Hafsa','Fatima',20)";
		  String sql="insert into EMP(eid,firstname,lastname,age)values(9,'Sasa','Khan',20)";
		    stmt.executeUpdate(sql);
		   // stmt.executeUpdate(sql);
		
		 conn.commit();
		System.out.println("Record inserted");
		//conn.close(); its not mandatory
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

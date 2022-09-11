import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertValues {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			Statement stmt=conn.createStatement();
			
		//String sql="insert into EMP(eid,firstname,lastname,age)values(345,'Ayesha','Fatima',22)";
		//stmt.executeUpdate(sql);
		  String sql=("INSERT INTO EMP(eid,firstname,lastname,age)values(356,'Sanvitha','Tirumala',22)");
			stmt.executeUpdate(sql);
		    sql=("INSERT INTO EMP(eid,firstname,lastname,age)values(389,'Neha','Khan',23)");
			stmt.executeUpdate(sql);
			System.out.println("Record is inserted in the table");
		}
      catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}

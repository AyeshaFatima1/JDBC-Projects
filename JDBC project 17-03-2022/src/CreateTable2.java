import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			Statement stmt=conn.createStatement();
			String sql="create table stud(eid int primary key not null,firstname varchar(255),lastname varchar(255),age int)";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database....");
		}
      catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}

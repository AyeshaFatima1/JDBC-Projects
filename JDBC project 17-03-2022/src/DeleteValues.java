import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteValues {

	public static void main(String[] args) {
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=null;
		 conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
		 Statement stm=conn.createStatement();
		 
		 String sql="delete from emp where eid=345 ";
		 stm.executeUpdate(sql);
		 System.out.println("vlaues are deleted....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

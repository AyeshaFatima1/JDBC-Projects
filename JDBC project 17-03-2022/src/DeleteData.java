import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			Statement stm=con.createStatement();
			
			String sql="delete from emp where eid=389";
			stm.executeUpdate(sql);
			
	        ResultSet rs=stm.executeQuery("Select eid,firstname,lastname,age from emp");
	        
	        while(rs.next()) {
	        	//display values
				System.out.println("eid:"+rs.getInt("eid"));
				System.out.println("firstname:"+rs.getString("firstname"));
				System.out.println("lastname:"+rs.getString("lastname"));
				System.out.println("age:"+rs.getInt("age"));
				
			}
			
			System.out.println("Records deleted sucessfully...");
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

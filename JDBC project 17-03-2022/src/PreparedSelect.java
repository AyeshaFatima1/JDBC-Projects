import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedSelect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
			PreparedStatement pstmt=conn.prepareStatement("select*from emp ");
            ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("eid:"+rs.getInt("eid"));
				System.out.println("firstname:"+rs.getString("firstname"));
				System.out.println("lastname:"+rs.getString("lastname"));
				System.out.println("age:"+rs.getInt("age"));
				
			}
			
				}
      catch(Exception e) {
    	  e.printStackTrace();
      }
   	}

}



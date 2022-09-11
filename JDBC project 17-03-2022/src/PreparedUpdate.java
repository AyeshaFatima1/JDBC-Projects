import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedUpdate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
			PreparedStatement pstmt=conn.prepareStatement("update emp set lastname=? where firstname=? ");
			
			pstmt.setString(1,"Khan");
			pstmt.setString(2,"Ayesha");
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"records updated");
			
			
				}
      catch(Exception e) {
    	  e.printStackTrace();
      }
   	}

}



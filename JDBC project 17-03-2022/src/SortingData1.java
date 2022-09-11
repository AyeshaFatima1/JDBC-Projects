import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SortingData1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
		 //PreparedStatement pstm=con.prepareStatement("select*from emp order by firstname asc");
			PreparedStatement pstm=con.prepareStatement("select firstname from emp order by firstname asc");
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()) {
			//System.out.println("eid:"+rs.getInt("eid"));
				System.out.println("firstname:"+rs.getString("firstname"));
			//System.out.println("lastname:"+rs.getString("lastname"));
			//System.out.println("age:"+rs.getInt("age"));
			}
			System.out.println("values are sorted");
		}
         catch(Exception e) {
        	 e.printStackTrace();
         }
		
		}

	}



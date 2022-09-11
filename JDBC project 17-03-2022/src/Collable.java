import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Collable {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	       
        // Getting the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db1", "root", "ayesha@7890");
       
        String sql_string = "insert into student values(?,?,?)";
       
        // Preparing a CallableStateement
        CallableStatement cs = con.prepareCall(sql_string);
         cs.setInt(1, 101);
         cs.setString(2,"Pavani");
         cs.setString(3, "Andhra");
        cs.execute();
        System.out.print("uploaded successfully\n");
        }
		catch(Exception e) {
			e.printStackTrace();
        }

	}

}

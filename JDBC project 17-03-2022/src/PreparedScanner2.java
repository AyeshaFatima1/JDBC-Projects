import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedScanner2 {


	public static void main(String[] args ) throws Exception{
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","ayesha@7890");
			
		    PreparedStatement pstmt=conn.prepareStatement("insert into emp values(?,?,?,?)");
			Scanner sc=new Scanner(System.in);
		    
			do {
			System.out.println("Enter id:");
			int eid =Integer.parseInt(sc.nextLine());
			pstmt.setInt(1, eid);
		
			System.out.println("Enter firstname:");
			String firstname =sc.nextLine();
			pstmt.setString(2,firstname);
			
		    System.out.println("Enter lastname:");
			String lastname =sc.nextLine();
			pstmt.setString(3,lastname);
			
			System.out.println("Enter age:");
			int age =Integer.parseInt(sc.nextLine());
			pstmt.setInt(4, age);
		
		int i=pstmt.executeUpdate();
		System.out.println(i+"records");
		System.out.println("Do you want o continue: yes/no");
		String s=sc.nextLine();
		if(s.startsWith("n")) {
			break;
		}
		}
			while(true);
			conn.close();
		}
		
}

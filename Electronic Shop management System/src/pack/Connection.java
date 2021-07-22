package pack;
import java.sql.*;


public class Connection {
	//Class.forName("com.mysql.jdbc.Driver");
	public java.sql.Connection con;
	void connection() {
	try {
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","newmysql87097");
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	
}

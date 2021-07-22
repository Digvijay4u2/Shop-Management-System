package pack;
import java.util.*;

import pack.Connection;

//import pack.Connection;

import java.sql.*;

public class Signup {
	
	 void sign() {
		 Scanner sc= new Scanner(System.in);
			Connection s=new Connection();
			

		try {
	s.connection();
	System.out.println("\nEnter Details for Signup : ");
	System.out.print("Enter First name :");
	String fu=sc.next();
	System.out.print("Enter Last name : ");
	String lu=sc.next();
	System.out.print("Enter Email_id : ");
	String e=sc.next();
	System.out.print("Enter Phone_number : ");
	String phone=sc.next();
	System.out.print("Enter your address : ");
	String a=sc.next();
	System.out.print("Enter username : ");
	String u=sc.next();
	System.out.print("Enter Password : ");
	String p=sc.next();
	System.out.println();
	String sql="INSERT INTO Account VALUES(?,?,?,?,?,'Customer','"+fu+"','"+lu+"')";
	PreparedStatement st= s.con.prepareStatement(sql);
	st.setString(1, u);
	st.setString(2, e);
	st.setString(3, phone);
	st.setString(4, a);
	st.setString(5,p);
	st.execute();
	Login l= new Login();
	l.log();

	}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			System.out.println("Sorry this username is taken by another user \nPlease try again\n");
			sign();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	 
}

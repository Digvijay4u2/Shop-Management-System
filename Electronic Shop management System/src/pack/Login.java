package pack;
import java.util.*;

import pack.Connection;

import java.sql.*;
public class Login {
	
	Scanner sc= new Scanner(System.in);
	Connection s=new Connection();
	public void log() {
		try {
	s.connection();
	System.out.println("\nEnter Details for Login :");
	System.out.print("Enter Username :");
	String u=sc.next();
	System.out.print("Enter Password : ");
	String p=sc.next();
	System.out.println();
	String sql="select username,password,role from Account where username=? and  password=?";
	PreparedStatement st= s.con.prepareStatement(sql);
	st.setString(1, u);
	st.setString(2, p);
	ResultSet rs=st.executeQuery();
	rs.next();
	String use=rs.getString("username");
	String pass =rs.getString("password");
	String role=rs.getString("role");
	//System.out.println(use +"  "+pass);
	if( role.equals("Boss") || role.equals("Manager")/*use.equals("Admin") && pass.equals("87097"*/)
	{
		Admin_permit ap=new Admin_permit();
		ap.function(use,role);
	}
	else {
	if(pass.equals(p) && use.equals(u))
	{
		System.out.println("***************************************************************************************************************************************************************************");
		System.out.println("\n                                                                             HELLO  "+" "+use);

		//System.out.println("Welcome  "+"  "+use);
	}
	else
		System.out.println("please signup first");
	
	
	System.out.println("***************************************************************************************************************************************************************************");
 System.out.println("1. View Profile  \n2. Change Password   \n3. View Items \n 4.Log out");
	System.out.println("***************************************************************************************************************************************************************************");
	System.out.print("Enter your choice : ");
	int choice =sc.nextInt();
	System.out.println("***************************************************************************************************************************************************************************");
   int cc=0;
	while(true) {
	switch(choice)
	{
	case 1:
		Statement sts = s.con.createStatement();
			ResultSet rrs=sts.executeQuery("select * from account where username='"+use+"'");
			System.out.println("Username\t    Fullname\t          Email\t              Phone\t   Address\t          Role\n");
			String full_name="";
			rrs.next();
			String item=rrs.getString("username");
			String fn=rrs.getString("first_name");
			full_name+=fn+" ";
			String ln=rrs.getString("last_name");
			full_name+=ln;
			String cat=rrs.getString("email");
			String item_name=rrs.getString("phone");
			String Price=rrs.getString("address");
			String amo = rrs.getString("password");
			String r=rrs.getString("role");
			
			System.out.printf("%-16s %-22s %-22s %-19s %-18s %-16s ",item,full_name,cat,item_name,Price,r);
			System.out.println();
			System.out.println("***************************************************************************************************************************************************************************");
			System.out.println("1. Review Profile  \n2. Change Password   \n3. View Items \n 4. Log out");
			System.out.println("***************************************************************************************************************************************************************************");
			System.out.print("Enter your choice : ");
		    choice =sc.nextInt();
			System.out.println("***************************************************************************************************************************************************************************");
		   
			break;
	case 2:
		System.out.println("***************************************************************************************************************************************************************************");
		System.out.print("Please Enter New password : ");
		String pas=sc.next();
		PreparedStatement ptr = s.con.prepareStatement("UPDATE account SET password=? where username=?");
		ptr.setString(1, pas);
		ptr.setString(2,use);
		ptr.execute();
		System.out.println("Your password changed successfully ");
		System.out.println("***************************************************************************************************************************************************************************");
		System.out.println("1. Review Profile  \n2. Change Password   \n3. View Items \n Log out");
		System.out.println("***************************************************************************************************************************************************************************");
		System.out.print("Enter your choice : ");
	    choice =sc.nextInt();
		System.out.println("***************************************************************************************************************************************************************************");
	   break;
	case 3: {cc=1;
		break;}
	case 4:Main m=new Main();
	m.fun();
	break;
	default:
	

	}
	if(cc==1)
		{Item_List il= new Item_List();
		il.list(u);
		break;}
	}
	
	
	
	
	
	
	
	
	
//	System.out.print("\nDO you want to change password Yes/No :");
//	String cpass=sc.next();
//	if(cpass.equals("Yes"))
//	{
//		System.out.print("Please Enter New password : ");
//		String pas=sc.next();
//		PreparedStatement ptr = s.con.prepareStatement("UPDATE account SET password=? where username=?");
//		ptr.setString(1, pas);
//		ptr.setString(2,use);
//		ptr.execute();
//		System.out.println("Your password changed successfully ");
//
//	}
//	else {}
//	Item_List il= new Item_List();
//	il.list(u);
	}
		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Sorry this username is taken by another user \nPlease try again\n");
			System.out.println("***************************************************************************************************************************************************************************");

			
		}
		catch(SQLException e2)
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Sorry , Username or password is wrong \n");
			System.out.println("Please Login again or Create new Account first ");
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("1 LOGIN  \n2 CREATE ACCOUNT \n3. EXIT ");
			//System.out.println("***************************************************************************************************************************************************************************");

			int select=sc.nextInt();
			System.out.println("***************************************************************************************************************************************************************************");

			if(select ==1)
			{
				log();
			}
			if(select==2) 
			{
			Signup sig= new Signup();
			sig.sign();
			}
			if(select==3)
				System.exit(0);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	
	}
	

}

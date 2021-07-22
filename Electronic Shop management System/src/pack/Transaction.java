package pack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Transaction {
	Scanner sc= new Scanner(System.in);
	Connection s=new Connection();
	void addTransaction(String user,String m,float total)
	{
		try {
		String sql;
		if(m.equals("Online"))
	  		 sql="INSERT INTO transaction(username,Payment_method,Transaction_date,total,Transaction_time) VALUES('"+user+"','Online',curdate(),"+total+",now())";
	  		else
		  		 sql="INSERT INTO transaction(username,Payment_method,Transaction_date,total,Transaction_time) VALUES('"+user+"','Cash',curdate(),"+total+",now())";

	  		PreparedStatement pps= s.con.prepareStatement(sql);
	  		pps.execute();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	void showTransaction(int role)
	{
		try {
		System.out.println("***************************************************************************************************************************************************************************");

		System.out.println("Transaction Statistics : \n");
		Statement sts = s.con.createStatement();
		ResultSet rrs=sts.executeQuery("select * from transaction");
		System.out.println("Username\t  Transaction_id\t  Total\t       Payment_method\t   Transaction_date\t  Transaction_time\n");
		while(rrs.next())
		{
			int item=rrs.getInt("Transaction_id");
			String cat=rrs.getString("username");
			String item_name=rrs.getString("payment_method");
			String Price=rrs.getString("Transaction_date");
			float amo = rrs.getFloat("total");
			String time=rrs.getString("Transaction_time");
			
			//System.out.println(item+"\t  "+cat+"\t  "+item_name+"\t  "+Price+"\t  "+amo+"        "+time);
			System.out.printf(" %-18s %-18s  %-16.2f  %-18s  %-20s  %-20s  ",cat,item,amo,item_name,Price,time  );
			System.out.println();
			
			
			
		}
		System.out.println("***************************************************************************************************************************************************************************");

		System.out.print(" Would you want to know about any customer details who makes transaction   Yes/No : ");
		String ch=sc.next();
		System.out.println("***************************************************************************************************************************************************************************");

		if(ch.equals("Yes"))
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.print("Enter Customer name :");
			String name=sc.next();
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Customer Details : ");
			 sts = s.con.createStatement();
			 rrs=sts.executeQuery("select distinct a.first_name,a.last_name,a.address,a.phone,a.email from account a, transaction t where a.username='"+name+"'");
			 //System.out.println("hhhhhhhhhhhhhhhh");
			//System.out.println("Username\t  Address\t  Phone\t  Email_id\t\n");
			String fullname="";
			rrs.next();
				String item=rrs.getString("a.first_name");
				fullname+=item+" ";
				String last=rrs.getString("a.last_name");
				fullname+=last;
				String cat=rrs.getString("a.address");
				String item_name=rrs.getString("a.phone");
				String Price=rrs.getString("a.email");
				
				//float amo = rrs.getFloat("total");
				//String time=rrs.getString("t.Payment_method");
				
				//System.out.println(item+"\t  "+cat+"\t  "+item_name+"\t  "+Price);
//				System.out.printf("%18s %20s %16s  %-20s",fullname,cat,item_name,Price);
//				System.out.println();
				System.out.println("Full Name: "+fullname);
				System.out.println("Phone No : "+item_name);
				System.out.println("Address  : "+cat);
				System.out.println("Email_id : "+Price);
				
				
				System.out.println("***************************************************************************************************************************************************************************");

			
		}
		
		if(role==1)
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("1. To enter into Account Profile Section    "
		
				+ "\n2. To enter into Item_list section         "
				+ "\n3. To enter into Transaction section to know transaction statistics "
				+ "\n4. Add Manager"
				+ "\n5. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

		}
		else if(role==2)
		{							System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("1. To enter into Account Profile Section    "
					
				+ "\n2. To enter into Item_list section         "
				+ "\n3. To enter into Transaction section to know transaction statistics "
				
				+ "\n5. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

	}}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		

}

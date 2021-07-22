package pack;
import java.sql.*;
import java.util.*;

//import pack.Connection;
public class Admin_permit 
{
	Scanner sc= new Scanner(System.in);
	Connection s=new Connection();
	int count=0;
	//int b_c=0;
	//int m_c=0;
	int role=0;
	
	void function(String u_name,String u_role)
	{
		try {
		s.connection();
		//count++;
		if(count==0) {
		if(u_role.equals("Boss")) 
			{							System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("                                                             #####   Welcome "+u_name+  "   (  Boss  )");
			//b_c=1;
			role=1;
			
			}
		else		{							System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("                                                              ####      Welcome "+u_name+  "   (  Manager  )");
			//m_c=1;
			role=2;
		}

			
			count++;
		}
		//System.out.println("What you want to know :");
		if(role==1)
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Please Enter \n1. To enter into Account Profile Section    "
		
				+ "\n2. To enter into Item_list section         "
				+ "\n3. To enter into Transaction section to know transaction statistics "
				+ "\n4. Add Manager"
				+ "\n5. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

		}
		else if(role==2)
		{
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Please Enter \n1. To enter into Account Profile Section    "
					
				+ "\n2. To enter into Item_list section         "
				+ "\n3. To enter into Transaction section to know transaction statistics "
				
				+ "\n5. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

		}
		while(true) {
		System.out.print("Enter your choice : ");
		int choice=sc.nextInt();
		System.out.println("***************************************************************************************************************************************************************************");

		if(choice==5)
		{
			Main m=new Main();
			m.fun();
			break;
		}
		switch(choice)
		{
		case 1:							System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. all Account Profile   \n2. Particular Account Profile    \n3. Go back");
				System.out.println("***************************************************************************************************************************************************************************");

				
				System.out.print("Enter your choice : ");
				choice=sc.nextInt();
				System.out.println("***************************************************************************************************************************************************************************");

				if(choice!=3) {
				switch(choice)
				{
				case 1:
					Statement sts = s.con.createStatement();
				ResultSet rrs=sts.executeQuery("select * from account");
				System.out.println("Username\t    email\t        Phone\t         Address\t   password\t          Role");
				System.out.println("==================================================================================================================");
				
				while(rrs.next())
				{
					String item=rrs.getString("username");
					String cat=rrs.getString("email");
					String item_name=rrs.getString("phone");
					String Price=rrs.getString("address");
					String amo = rrs.getString("password");
					String r=rrs.getString("role");
					if(role==1) {
					if(r.equals("Boss"))
						continue;}
					if(role==2)
					{
						if(r.equals("Boss")||r.equals("Manager"))
							continue;
					}
					
					
					//System.out.println(item+"\t  "+cat+"\t  "+item_name+"\t  "+Price+"\t  "+amo+"     "+r);
					System.out.printf("%-16s %-22s %-16s %-19s %-18s %-16s ",item,cat,item_name,Price,amo,r);
					System.out.println();
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					
					
					
				}							System.out.println("***************************************************************************************************************************************************************************");

				System.out.print("Do you want to delete any Customer Yes/No :");
				String choose=sc.next();
				//System.out.println("??????................................??????");
				if(choose.equals("Yes"))
				{
					System.out.print("Enter the username : ");
					String uname=sc.next();
					PreparedStatement ptr = s.con.prepareStatement("delete from account where username='"+uname+"'");
					ptr.executeUpdate();
					System.out.println(uname +" Account deleted successfully ");
					System.out.println("***************************************************************************************************************************************************************************");

				}
				else
				{
//					System.out.println("Please Enter 1. To enter into Customers Section    "
//							+"2. To enter into Item_list section"
//							+ "3. To enter into Transaction section ");
				}
				
				break;
				case 2:
				System.out.println("You have to Enter correct username of customer ");
				System.out.println("--------------------------------------------");
				System.out.print("Enter username : ");
				String name=sc.next();
				System.out.println("***************************************************************************************************************************************************************************");

				 sts = s.con.createStatement();
				rrs=sts.executeQuery("select * from account where username='"+name+"'");
				System.out.println("Username\t    email\t        Phone\t         Address\t   password\t          Role\n");

				rrs.next();
				String item=rrs.getString("username");
				String cat=rrs.getString("email");
				String item_name=rrs.getString("phone");
				String Price=rrs.getString("address");
				String amo = rrs.getString("password");
				String r=rrs.getString("role");
				
				System.out.printf("%-16s %-22s %-16s %-19s %-18s %-16s ",item,cat,item_name,Price,amo,r);
				System.out.println();
				System.out.println("***************************************************************************************************************************************************************************");

				System.out.print("Do you want to delete this Customer Yes/No :");
				//System.out.println("?????................................?????");
				 choose=sc.next();
				if(choose.equals("Yes"))
				{
//					System.out.print("Enter the username : ");
//					String uname=sc.next();
					PreparedStatement ptr = s.con.prepareStatement("delete from account where username='"+item+"'");
					ptr.executeUpdate();
					System.out.println(item +" Account deleted successfully ");
					System.out.println("***************************************************************************************************************************************************************************");


				}
				else
				{
//					System.out.println("Please Enter 1. To enter into Customers Section    "
//							+"2. To enter into Item_list section"
//							+ "3. To enter into Transaction section ");
				}
				
				break;
				default :
					
				}}
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
				}
				break;
		case 2:
			//System.out.println("***************************************************************************************************************************************************************************");
			System.out.println("                                                                                ITEM LIST SECTION");
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item  \n5.G0 Back    \n6. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

			while(true) {
				System.out.print("Enter your choice : ");
			int c =sc.nextInt();
			System.out.println("***************************************************************************************************************************************************************************");

			if(c==5) {
				if(role==1)
				{							System.out.println("***************************************************************************************************************************************************************************");

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

				}
				
				break;}
			if(c==6)
			{
				Main m= new Main();
				m.fun();
				break;
			}
			switch(c)
			{
			
			case 1:							System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("\n1.  All Items  \n2. By Category   \n3. Go back");
			//System.out.println("\n1. Products      2.      choice3");
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.print("Enter your choice :");
			 choice=sc.nextInt();
				System.out.println("***************************************************************************************************************************************************************************");

			if(choice!=3) {
			switch(choice)
			{
			case 1:Statement sts = s.con.createStatement();
				ResultSet rrs=sts.executeQuery("select * from item_list");
				//System.out.println("Item_id\t  Category\t  Item_name\t  Price\t\t  Amount\n");
				System.out.println("Item_id\t         Category\t         Item_name\t  Price\t             Quantity\t      ");
				System.out.println("======================================================================================");

				while(rrs.next())
				{
					String item1=rrs.getString("Item_id");
					String cat1=rrs.getString("Category");
					String item_name1=rrs.getString("Item_name");
					float Price1=rrs.getFloat("Price");
					int amo1 = rrs.getInt("Item_Amount");
					
					//System.out.println(item+"\t  "+cat+"\t  "+item_name+"\t  "+Price+"\t  "+amo);
					//System.out.printf(" %-16s %-22s %-16s %-19s %-18.2f %-16.0f \n",item1,cat1,item_name1,Price1,amo1);
					System.out.printf("%-16s| %-22s| %-16s| %-19s| %-18s ",item1,cat1,item_name1,Price1,amo1);
					System.out.println();
					System.out.println("------------------------------------------------------------------------------------");
					//System.out.println();

					
				}
//				if(select>0)
//					System.out.println("\nEnter 1. To view all Items avilable     2. To view Items by Category     3. To Add more items to cart    4. For Payment");
//				else
//				System.out.println("\nEnter 2. for Category   3. for Add to cart ");
				//String cart=sc.next();
				System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item   \n5. G0 Back   \n6. Log out");

				System.out.println("***************************************************************************************************************************************************************************");

				
				break;
			
			case 2:while(true) {							System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. Mobile  \n2. T.V  \n3. Laptop  \n4. Go back");
				System.out.println("***************************************************************************************************************************************************************************");
System.out.print("Enter your choice : ");
					 choice =sc.nextInt();
						System.out.println("***************************************************************************************************************************************************************************");

					 if(choice==4)
					 {							System.out.println("***************************************************************************************************************************************************************************");

							System.out.println("1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item   \n5. To Back   \n6. Log out");
							System.out.println("***************************************************************************************************************************************************************************");

						 break;
					 }
					 else
					 {
					 switch(choice)
					 {
					 case 1: Statement state = s.con.createStatement();
						ResultSet rss=state.executeQuery("select * from item_list where Category='Mobile'");
						System.out.println("Item_id\t         Category\t         Item_name\t  Price\t             Quantity\t      ");
						System.out.println("======================================================================================");
						while(rss.next())
						{
							String item=rss.getString("Item_id");
							String cat=rss.getString("Category");
							String item_name=rss.getString("Item_name");
							String Price=rss.getString("Price");
							int amo = rss.getInt("Item_Amount");
							
							System.out.printf("%-16s| %-22s| %-16s| %-19s| %-18s ",item,cat,item_name,Price,amo);
							System.out.println();
							System.out.println("------------------------------------------------------------------------------------");

					 }
						

				break;
					 case 2:Statement state1 = s.con.createStatement();
						ResultSet rss1=state1.executeQuery("select * from item_list where Category='T.V'");
						System.out.println("Item_id\t         Category\t         Item_name\t  Price\t             Quantity\t      ");
						System.out.println("======================================================================================");
						while(rss1.next())
						{
							String item=rss1.getString("Item_id");
							String cat=rss1.getString("Category");
							String item_name=rss1.getString("Item_name");
							String Price=rss1.getString("Price");
							int amo = rss1.getInt("Item_Amount");
							
							System.out.printf("%-16s| %-22s| %-16s| %-19s| %-18s ",item,cat,item_name,Price,amo);
							System.out.println();
							System.out.println("------------------------------------------------------------------------------------");

					 }


				break;
					 case 3:
						 Statement state2 = s.con.createStatement();
							ResultSet rss2=state2.executeQuery("select * from item_list where Category='Laptop'\n");
							System.out.println("Item_id\t         Category\t         Item_name\t  Price\t             Quantity\t      ");
							System.out.println("======================================================================================");
							while(rss2.next())
							{
								String item=rss2.getString("Item_id");
								String cat=rss2.getString("Category");
								String item_name=rss2.getString("Item_name");
								String Price=rss2.getString("Price");
								int amo = rss2.getInt("Item_Amount");
								
								System.out.printf("%-16s| %-22s| %-16s| %-19s| %-18s ",item,cat,item_name,Price,amo);
								System.out.println();
								System.out.println("------------------------------------------------------------------------------------");

						 }
//							if(select>0)
//								System.out.println("\nEnter 1. To view all Items avilable     2. To view Items by Category     3. To Add more items to cart    4. For Payment");
//							else
//							System.out.println("\nEnter 1. for All    2. for Category     3. for Add to cart ");
					 }//System.out.println("Press 1. Read Item_list   2. update Item_list   3.delete Item_list  4. Add new_Item   5. To Back   6. Log out");

					 
					//break;
					 }					System.out.println("***************************************************************************************************************************************************************************");

						System.out.println("1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item   \n5. To Back   \n6. Log out");
						System.out.println("***************************************************************************************************************************************************************************");

					 //break;
//			case 3:
			break;
			}default:System.out.println();
			
			}}
			//System.out.println("Press 1. Read Item_list   2. update Item_list   3.delete Item_list  4. Add new_Item   5. To Back   6. Log out");
			break;
			
			case 2:  //System.out.println("update"); 
			 				//for update
				System.out.println("Available Items ");
				System.out.println("-----------------");
				Statement sts = s.con.createStatement();
				ResultSet rrs=sts.executeQuery("select * from item_list");
				System.out.println("Item_id\t         Category\t         Item_name\t  Price\t             Quantity\t      ");
				System.out.println("======================================================================================");
				while(rrs.next())
				{
					String item=rrs.getString("Item_id");
					String cat=rrs.getString("Category");
					String item_name=rrs.getString("Item_name");
					String Price=rrs.getString("Price");
					int amo = rrs.getInt("Item_Amount");
					
					System.out.printf("%-16s| %-22s| %-16s| %-19s| %-18s ",item,cat,item_name,Price,amo);
					System.out.println();
					System.out.println("------------------------------------------------------------------------------------");

			 }
				System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("\nYou can edit only Price or Quantity or both of an Item  ");
					System.out.println("-----------------------------------------------------------");
					System.out.println("\n1. To update only Price   \n2. To edit only Quantity     \n3. To edit both Price and Quantity    \n4. G0 Back");
					System.out.println("***************************************************************************************************************************************************************************");

					System.out.print("Enter your choice : ");
					choice =sc.nextInt();
					System.out.println("***************************************************************************************************************************************************************************");

					if(choice!=4) {
					switch(choice)
					{
					case 1:							System.out.println("***************************************************************************************************************************************************************************");

						System.out.print("Please enter Item_id of an Item to update the Price : ");
					 		String item=sc.next();
					 		System.out.print("Enter new Price of Item :");
							float price=sc.nextFloat();
							System.out.println("***************************************************************************************************************************************************************************");

							PreparedStatement ptr = s.con.prepareStatement("UPDATE item_list SET Price="+price+" where item_id='"+item+"'");
							ptr.execute();
							break;
					case 2:
						System.out.println("***************************************************************************************************************************************************************************");
System.out.print("Please enter Item_id of an Item to update the Quantity : ");
			 		 item=sc.next();
			 		System.out.print("Enter new Quantity of Item :");
					float quant=sc.nextFloat();
					System.out.println("***************************************************************************************************************************************************************************");

					 ptr = s.con.prepareStatement("UPDATE item_list SET Item_Amount="+quant+" where item_id='"+item+"'");
					ptr.execute();
					break;
					case 3:							System.out.println("***************************************************************************************************************************************************************************");

						System.out.print("Please enter Item_id of an Item to update the Quantity : ");
			 		 item=sc.next();
			 		System.out.print("Enter new Price of Item :");
			 		 price=sc.nextFloat();
			 		System.out.print("Enter new Quantity of Item :");
					 quant=sc.nextFloat();
						System.out.println("***************************************************************************************************************************************************************************");

					 ptr = s.con.prepareStatement("UPDATE item_list SET Item_Amount="+quant+",Price="+price+" where item_id='"+item+"'");
					ptr.execute();
					break;
					}
					

					}
					else {}
					System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item   \n5. To Back   \n6.Log out");
					System.out.println("***************************************************************************************************************************************************************************");


				break;
			case 3:                          //  System.out.println("delete");       //for delete
			     	System.out.print("Enter Item_id to delete an Item : ");
			     	String item_id=sc.next();
			     	PreparedStatement ptr = s.con.prepareStatement("delete from item_list where item_id='"+item_id+"'");
					ptr.executeUpdate();
					System.out.println(" Item having Item_id "+item_id+"  is deleted from Item_list ");
					System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("\n1. Read Item_list   \n2. update Item_list   \n3.delete Item_list  \n4. Add new_Item   \n5. To Back   \n6.Log out");
					System.out.println("***************************************************************************************************************************************************************************");

			     	
				break;
			case 4:            // System.out.println("add");    //add
				System.out.println("***************************************************************************************************************************************************************************");

			 		System.out.println("Please give all details of an Item to add that into Item_list ");
			 		System.out.println("----------------------------------------------------");
			 		System.out.print("Enter Item_id : ");
			 		String id=sc.next();
			 		System.out.print("Enter Category of Item ( Mobile / T.V / Laptop ): ");
			 		String  cat=sc.next();
			 		System.out.print("Enter name of Item : ");
			 		String name=sc.next();
			 		System.out.print("Enter Price of Item : ");
			 		float price=sc.nextFloat();
			 		System.out.print("Enter Quantity of Item : ");
			 		float quant=sc.nextFloat();
			 		//int qqqqqq=quant;
					System.out.println("***************************************************************************************************************************************************************************");

			 		
			 		String sql="INSERT INTO item_list VALUES('"+id+"','"+cat+"','"+name+"',"+price+","+quant+")";
			 		PreparedStatement st= s.con.prepareStatement(sql);
//			 		st.setString(1, u);
//			 		st.setString(2, e);
//			 		st.setString(3, phone);
//			 		st.setString(4, a);
//			 		st.setString(5,p);
			 		st.execute();
			 		System.out.println((int)quant+" Items having Item_id "+id+" and Item_name "+name+" is successfully Added to Item_list");
					System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("1. Read Item_list   \n2. update Item_list   \n3. delete Item_list  \n4. Add new_Item   \n5. To Back    \n6.Log out");
					System.out.println("***************************************************************************************************************************************************************************");

			 		
				break;
//			case 5:{
//				break;
//			}
				
				
			
			}
			
			
			

			}                //for while loop in read update delete items
			break;
			
		case 3: //System.out.println("Transaction");							
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

		}
		break;
		case 4:if(role==1) {
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("\nEnter Details Of Manager : ");
			System.out.print("Enter First name :");
			String fu=sc.next();
			System.out.print("Enter Last name :");
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
			//System.out.println("***************************************************************************************************************************************************************************");

			System.out.println();
			String sql="INSERT INTO Account VALUES(?,?,?,?,?,'Manager','"+fu+"','"+lu+"')";
			PreparedStatement st= s.con.prepareStatement(sql);
			st.setString(1, u);
			st.setString(2, e);
			st.setString(3, phone);
			st.setString(4, a);
			st.setString(5,p);
			st.execute();
		System.out.println(fu+" "+lu+" become Manager successfully\n");
		System.out.println("***************************************************************************************************************************************************************************");

		System.out.println("1. To enter into Customers Section    "
				+ "\n2. To enter into Item_list section         "
				+ "\n3. To enter into Transaction section to know transaction statistics "
				+ "\n4. Add Manager"
				+ "\n5. Log out ");
		System.out.println("***************************************************************************************************************************************************************************");
}
		else {
			System.out.println("Invalid input ");
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("Please Enter 1. To enter into Customers Section   "
					+ "\n2. To enter into Item_list section         "
					+ "\n3. To enter into Transaction section to know transaction statistics "
					+ "\n5. Log out ");
			System.out.println("***************************************************************************************************************************************************************************");

		}
		break;
			default :System.out.println("Invalid Input");
				
			
		}
		} 
		}
		catch(java.sql.SQLException e1)
		{
			System.out.println("Something went wrong");
			function(u_name,u_role);
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.getStackTrace();
		}
	}

}

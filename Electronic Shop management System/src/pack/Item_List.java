package pack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Item_List {
	Scanner sc= new Scanner(System.in);
	Connection s=new Connection();
	int select=0;
	void list(String u)
	{
		
		
		try
		{
			s.connection();
			PreparedStatement ps =s.con.prepareStatement("insert into user_id(username) values (?)");
			ps.setString(1, u);
			ps.execute();
			ps =s.con.prepareStatement("select last_insert_id() as current");
			//ps.setString(1, u);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int cus_id=rs.getInt("current");
		
			System.out.println("\nDo you want to view All Products or By Category :");
			System.out.println("-------------------------------------------------");
			
			System.out.println("1. All Items  \n2. By Category  \n5.Log out");
			System.out.println("***************************************************************************************************************************************************************************");

			//System.out.println("\n1. Products      2.      choice3");
			while(true) {
			System.out.print("Enter your choice :");
			int choice=sc.nextInt();
			System.out.println("***************************************************************************************************************************************************************************");

			if(choice==5)
			{
				Main m= new Main();
				
				m.fun();
				break;
			}
			
			switch(choice)
			{
			case 1:Statement sts = s.con.createStatement();
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
				if(select>0)
					{		System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. For Payment   \n5.Log out  \n6. Cart");
					System.out.println("***************************************************************************************************************************************************************************");
					}
				else
				{		System.out.println("***************************************************************************************************************************************************************************");

					System.out.println("2. for Category   \n3. for Add to cart   \n5. Log out   \n6. Cart");
					System.out.println("***************************************************************************************************************************************************************************");
				}
				//String cart=sc.next();
				
				
				break;
			
			case 2:		System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. Mobile  \n2. T.V  \n3. Laptop ");
				System.out.println("***************************************************************************************************************************************************************************");

System.out.print("Enter your choice : ");
					 choice =sc.nextInt();
						System.out.println("***************************************************************************************************************************************************************************");

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
						if(select>0)
						{		System.out.println("***************************************************************************************************************************************************************************");

						System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. For Payment   \n5.Log out  \n6. Cart");
						System.out.println("***************************************************************************************************************************************************************************");
						}
					else
					{		System.out.println("***************************************************************************************************************************************************************************");

						System.out.println("1.For all \n2. G0 Back ( Category )   \n3. for Add to cart   \n5. Log out   \n6. Cart");
						System.out.println("***************************************************************************************************************************************************************************");
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
						if(select>0)
						{		System.out.println("***************************************************************************************************************************************************************************");

						System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. For Payment   \n5.Log out  \n6. Cart");
						System.out.println("***************************************************************************************************************************************************************************");
						}
					else
					{		System.out.println("***************************************************************************************************************************************************************************");

						System.out.println("1. for all \n2. G0 Back ( Category )   \n3. for Add to cart   \n5. Log out   \n6. Cart");
						System.out.println("***************************************************************************************************************************************************************************");
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
							if(select>0)
							{		System.out.println("***************************************************************************************************************************************************************************");

							System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. For Payment   \n5.Log out   \n6. Cart");
							System.out.println("***************************************************************************************************************************************************************************");
							}
						else
						{		System.out.println("***************************************************************************************************************************************************************************");

							System.out.println("1. for all \n2. G0 Back ( Category )   \n3. for Add to cart   \n5. Log out    \n6. Cart");
							System.out.println("***************************************************************************************************************************************************************************");
						}

					break;
					 }	
					 break;
			case 3: System.out.println("Please Enter Item_id and  Quantity ");
			System.out.print("Enter Item_id : ");
			String id=sc.next();
			System.out.print("Enter Quantity : ");
			Float quant=sc.nextFloat();
			//Prepared
			PreparedStatement st= s.con.prepareStatement("select Item_Amount from item_list where Item_id='"+id+"'");
			ResultSet rst=st.executeQuery();
			rst.next();
			float q=rst.getFloat("Item_Amount");
			//System.out.println(q);
			if(q==0) {
				System.out.println("Sorry , No item available of Item_id "+""+id);
				System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. for All    \n2. for Category     \n3. for Add to cart     \n5.Log out ");
				System.out.println("***************************************************************************************************************************************************************************");

			}
			else if(q<quant) {
				System.out.println("Sorry , only  "+(int)q+" item available of Item_id "+""+id);
				System.out.println("***************************************************************************************************************************************************************************");

				System.out.println("1. for All    \n2. for Category     \n3. for Add to cart     \n5.Log out ");
				System.out.println("***************************************************************************************************************************************************************************");

			}
			else {
//System.out.println("sdfhj");
			String sql="INSERT INTO cart VALUES(?,?,?,curdate(),?)";
			  PreparedStatement stt= s.con.prepareStatement(sql);
			stt.setString(1, u);
			stt.setString(2, id);
			stt.setFloat(3, quant);
			stt.setInt(4, cus_id);
			stt.execute();
			stt.close();
//			if(q-quant==0)
//			{
//				PreparedStatement ptr = s.con.prepareStatement("delete from item_list where item_id='"+id+"'");
//				ptr.executeUpdate();
//			}
			//System.out.println("fdshj");
			PreparedStatement sttt = s.con.prepareStatement("UPDATE item_list SET Item_Amount=Item_Amount-"+quant+" where item_id='"+id+"'");
			sttt.executeUpdate();
			
			select++;
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. To Generate Bill     \n5.Log out  \n6. Cart");
			System.out.println("***************************************************************************************************************************************************************************");

			}
			break;
			
			case 4://System.out.println("hi");
				System.out.println("***************************************************************************************************************************************************************************");
				System.out.println("                                        ###                       <><><><>      Bill Recipt     <><><><>                     ###  ");
				System.out.println("                                                                             ------------------                 ");
				
				Statement st1 = s.con.createStatement();
				  ResultSet rrs1=st1.executeQuery("select distinct t.Payment_method,t.transaction_date,a.username,a.address,a.phone,a.email from account a, transaction t where a.username='"+u+"'");
				 //System.out.println("hhhhhhhhhhhhhhhh");
				//System.out.println("Username\t  Address\t  Phone\t  Email_id\t\n");
				rrs1.next();
					String name=rrs1.getString("a.username");
					String add=rrs1.getString("a.address");
					String phone=rrs1.getString("a.phone");
					String email=rrs1.getString("a.email");
					String date=rrs1.getString("t.transaction_date");
				//	String method1=rrs1.getString("t.Payment_method");
					
					System.out.println("         Customer Name : "+name+"                                                                                             Address  : "+add)  ;
					System.out.println();
					System.out.println("         Phone         : "+phone+"                                                                                         Email_id : "+email);
					
					System.out.println("\n");
				
				
				
					
				
				
				
				
				st= s.con.prepareStatement("select distinct i.Item_name,i.Price,c.Quantity,i.Price*c.Quantity as total, c.Purchase_date from cart c,item_list i where c.customer_id=? and c.Item_id=i.Item_id ");
				//st.setString(1, u);
				st.setInt(1, cus_id);
				System.out.println("                                         ------------------------------------------------------------------");
				System.out.println("                                         Item_name \t -    Price\t    -   Quantity\t    -      Total");
				System.out.println();
				 rs=st.executeQuery();
				//System.out.println("\n\nCustomer : "+u);
				float f=0;
				//String total_="";
				//String date=rs.getString("c.Purchase_date");
				while(rs.next())
				{
					//String iid=rs.getString("c.Item_id");
					String iname=rs.getString("i.Item_name");
					String iPrice=rs.getString("i.Price");
					String cQuant=rs.getString("c.Quantity");
					String total=rs.getString("total");
					//int i=Integer.parseInt(total);
					//f=f+i;
					//String total_=rs.getString("fulltotal");
					float p=Float.parseFloat(iPrice);
					float qu=Float.parseFloat(cQuant);
					f=f+p*qu;

					

					
					//System.out.println(iname+"    "+iPrice+"    	"+cQuant+" 		"+total);
					System.out.printf("                                         %-18s| %-19s| %-18s| %-20s ",iname,iPrice,cQuant,total);
					System.out.println();
				}
				System.out.println("                                         ------------------------------------------------------------------");

				System.out.println("\n    Total Amount to be pay  : "+f);
				System.out.println("   =========================================");
				System.out.println();
				System.out.println("    Date :"+date+"                                                                                                         Signature");
				rs.close();
				
				
				
//			  		st= s.con.prepareStatement("select sum(c.Quantity*i.Price) as sum from cart c,item_list i,user_id u where c.Item_id=i.Item_id and u.username=? and c.customer_id=?");
//			  		st.setString(1, u);
//			  		st.setInt(2, cus_id);
//			  		 rs=st.executeQuery();
//			  		rs.next();
//			  		String sum=rs.getString("sum");
//			  		System.out.println("Total : "+sum);
//			  		float t=Float.parseFloat(sum);
			  		System.out.println("\n");
					System.out.println("***************************************************************************************************************************************************************************");

			  		System.out.print("Do you want Pay the Bill Yes/No :");
			  		String ans=sc.next();
			  		if(ans.equals("Yes")) {
						System.out.println("***************************************************************************************************************************************************************************");

			  		System.out.println("Which Payment method do you want to choose  \n1. Online   \n2. Cash on delivery");
					System.out.println("***************************************************************************************************************************************************************************");

			  		System.out.print("Enter your choice :");
			  		
			  		int choose=sc.nextInt();
					System.out.println("***************************************************************************************************************************************************************************");

			  		String sql;
			  		if(choose==1)
			  		 sql="INSERT INTO transaction(username,Payment_method,Transaction_date,total,Transaction_time) VALUES('"+u+"','Online',curdate(),"+f+",now())";
			  		else
				  		 sql="INSERT INTO transaction(username,Payment_method,Transaction_date,total,Transaction_time) VALUES('"+u+"','Cash',curdate(),"+f+",now())";

			  		PreparedStatement pps= s.con.prepareStatement(sql);
			  		pps.execute();
			  		
			  		System.out.println("Payment Susccessful \n Good day\n\n");
					System.out.println("***************************************************************************************************************************************************************************");

			  		System.out.println("1. To purchase items again  \n2. Log out  ");
System.out.print("Enter your choice : ");
		  			int ch=sc.nextInt();
					System.out.println("***************************************************************************************************************************************************************************");

		  			switch(ch)
		  			{
		  			case 1:
		  				Item_List il=new Item_List();
		  				il.list(u);
		  				break;
		  			case 2:
		  				Main m=new Main();
		  				m.fun();
		  			}
			  		
			  		}
			  		else
			  		{System.out.println(" Bill payment unsuccessful \nHope you purchase next time");
						System.out.println("***************************************************************************************************************************************************************************");

			  			System.out.println("1. To purchase items again  \n2. Log out  ");
			  			System.out.print("Enter your choice :");
			  			int ch=sc.nextInt();
						System.out.println("***************************************************************************************************************************************************************************");

			  			switch(ch)
			  			{
			  			case 1:
			  				Item_List il=new Item_List();
			  				il.list(u);
			  				break;
			  			case 2:
			  				Main m=new Main();
			  				m.fun();
			  			}
			  		}
			  		break;
			case 6:						
System.out.println("                                                                   #####              |    CART     |                #####");
System.out.println("                                                                                      ================");

				Statement scart = s.con.createStatement();
				 rrs=scart.executeQuery("select * from cart where customer_id="+cus_id+"");
				 //System.out.println("hhhhhhhhhhhhhhhh");
				//System.out.println("Username\t  Address\t  Phone\t  Email_id\t\n");
				System.out.println("                                                                             Item_id                   Quantity");
				
				System.out.println();
				while(rrs.next()) {
					String item=rrs.getString("Item_id");
					
					String last=rrs.getString("Quantity");
					
					
					
					//float amo = rrs.getFloat("total");
					//String time=rrs.getString("t.Payment_method");
					
					//System.out.println(item+"\t  "+cat+"\t  "+item_name+"\t  "+Price);
//					System.out.printf("%18s %20s %16s  %-20s",fullname,cat,item_name,Price);
//					System.out.println();
					System.out.println(  "                                                                                 "+item   +"                   "+last);
					
				}
				System.out.println("***************************************************************************************************************************************************************************");
				System.out.println("1. To view all Items avilable     \n2. To view Items by Category     \n3. To Add more items to cart    \n4. For Payment   \n5.Log out  \n6. Cart");

				System.out.println("***************************************************************************************************************************************************************************");

				break;
			
			default:
			}
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

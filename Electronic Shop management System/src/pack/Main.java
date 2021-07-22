package pack;
import java.util.*;


public class Main {
	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args)
	{
		

		Main m= new Main();
		
		m.fun();		
		
		}
		void fun()
		{
			System.out.println("************************************************************************<><><><><><<>><><><><><><>**************************************************************************");
			System.out.println("\n                                                                           Welcome to our Store");
			System.out.println("\n                                                                              !!!!!!!!!!!!!!!  ");
			System.out.println("                                                                              ***************  ");
			System.out.println("***************************************************************************************************************************************************************************");

//			System.out.println("\t\t\t\t\t   please choose one of the Option\n ");
//			System.out.println("\t\t\t\t\t               PRESS\n ");

			System.out.println("1. LOGIN                                        \n2. CREATE ACCOUNT                    \n3. EXIT");
			System.out.println("***************************************************************************************************************************************************************************");

			System.out.print("Enter your choice  : ");
			int choice=sc.nextInt();
			switch(choice)
			{
			
			case 1 : Login log = new Login();
					log.log();
					break;
					
			case 2: Signup ss= new Signup();
					ss.sign();
					break;
			case 3:System.out.println(" Bye ");
				System.exit(0);
			default:System.out.println("default");
			break;
		}
		
		
	}

}

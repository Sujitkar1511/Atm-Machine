
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;
class Atmcard
{
	protected String Name;
	protected Long Mobile;
	protected int PW,ran;
	private String Birth;
	private int dateofbirth;
	public int Repass;
	protected int Balance=5000;
	public int[]randomnumber=new int[4];
	private int cardnum,passnum,forgate;
	private long Rmobile;
	protected String Reset="\u001B[0m";
	Scanner in=new Scanner(System.in);
	public void valid1()
	{
		System.out.print("\u001B[35m"+"			Entre the last 4 digit Card Number:");
		cardnum=in.nextInt();
		System.out.print("		Enter the 4digit password:");
		passnum=in.nextInt();
		System.out.println("	..............................................................."+Reset);
		if(cardnum==randomnumber[3])
		{
			System.out.println("\u001B[34m"+"				Card number is Match");
			if(passnum==PW)
			{
				System.out.println("\u001B[34m"+"				Password is Match");
				System.out.println("	...................................................."+"\u001B[0m");
			}
			else
			{
				System.out.println("\u001B[31m"+"				Password is not Match");
				System.out.println("\u001B[34m"+" 	 	Forgate Password(Press1) Exit(Press2)");
				System.out.print("       		 →");
				forgate=in.nextInt();
				switch(forgate)
				{
					case 1:
						System.out.print("\u001B[38;5;211m"+"			Enter the Register Mobile Number:");
						Rmobile=in.nextLong();
						if(Rmobile==Mobile)
						{
							System.out.println("\u001B[34m"+"				Mobile Number is Match");
							Password1();
						}
						else
						{
							System.out.println("\u001B[31m"+"			Your Register Mobile number is Not Match");
							System.out.println("		 Contuct Your Branch");
							System.exit(1);
						}
						break;
					case 2:
						System.out.println("\u001B[31m"+"		Contact Your Branch");
						System.out.println("		.............................................");
						System.exit(1);
				}
			}
		}
		else
		{
			System.out.println("\u001B[31m"+"				Card Number is Not Match");
			System.out.println("			  Contact Your Branch");
			System.out.println("	..............................................................");
			System.exit(1);
		}
	}
	public void Password1()
	{
		System.out.print("		Enter the New Password:");
		Repass=in.nextInt();
		PW=Repass;
		System.out.println("\n		Your Password is Change");
		valid1();
	}
	public void PrintCard()
	{
		System.out.println("\u001B[33m"+"\n		............Card Details........."+Reset);
		System.out.println("\u001B[32m"+"\n		FullName:"+Name);
		System.out.println("		Mobile Number:"+Mobile);
		System.out.print("		Card Number:");
		Cardnumber();
		System.out.println("\n		Password:"+PW);
		System.out.println("      		Age:"+dateofbirth+"year old");
	}
	public void Cardnumber()
	{
		for(int i=1;i<4;i++)
		{
		Random random = new Random();
		 ran = random.nextInt(10000 - 1000) + 1000;
		 randomnumber[i]=ran;
		}
		for(int i=1;i<4;i++)
		{
			System.out.print(randomnumber[i]);
		}
	
	}
 	public void Timedelay()
	{
 		System.out.print("\u001B[31m"+"			Wait card is Process.......");
		try {
            Thread.sleep(3000); 
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("Card is Ready");
	}
	public int Birthdate()
	{
	LocalDate curDate = LocalDate.now(); 
	Scanner in=new Scanner(System.in);
	System.out.print("\u001B[38;5;208m"+"			Enter Date of Birth in (YYYY-MM-DD) format: ");  
	 Birth=in.nextLine(); 
	 LocalDate dob = LocalDate.parse(Birth); 
	 dateofbirth=Period.between(dob, curDate ).getYears();
	 if(dateofbirth>=19)
	 {
		 return dateofbirth;
	 }
	 else
	 {
		 System.out.println("\n.........................................");
		 System.out.println("       You not Applied the ATM Card");
		 System.out.println(".........................................");
		 System.exit(1);
	 }
	 //System.out.println("You are " + dateofbirth+" years old.");
	return dateofbirth;
	}
	public void Mobilenumber()
	{
		System.out.print("\u001B[32m"+"			📲☎️Enter the Card Holder Mobile Number(+91):");
		Mobile=in.nextLong();
		long temp=Mobile;
		int count=0;
		while(temp!=0)
		{
		 count+=1;
		 temp=temp/10;
		}
		if(count==10)
		{
			//System.out.println("\n		........Valid Number.....\n");
			Password();
		}
		else
		{
			System.out.println("\u001B[38;5;208m"+"\n			......Invaild Number......");
			System.out.println("       			  Plz check the number   ");
			System.exit(1);
		}
	}
	public void Password()
	{
		System.out.print("\u001B[31m"+"			Enter the PassWord(4 digit):");
		PW=in.nextInt();
		int temp=PW,rem,Conf;
		int c=0;
	    while(temp!=0)
	    {
	      rem=temp%10; 
	      c+=1;
	      temp=temp/10;
	   }
	    
	   if(c==4)
	   {
		   System.out.print("\u001B[38;5;117m"+"			Confarm Password:");
		   Conf=in.nextInt();
		   if(PW==Conf)
		   {
			   //System.out.println("......Password Match.....");
			   Birthdate();
		   }
		   else
		   {
			   System.out.println("\u001B[31m"+"\n		.........................................");
			   System.out.println(" 		  ........Password is Not Match.....");
			   System.out.println("    		  Plz enter the valid password");
		       System.out.println("        		    Plz Try Again");
		       System.out.println("		.........................................\n");
		       System.exit(1);
		   }
	   }
	   else
	   {
		   System.out.println("\u001B[31m"+"\n		.........................................");
		   System.out.println("	       		  Plz Enter Valid Password");
		   System.out.println("        		    	Try Again    ");
		   System.out.println("		.........................................\n");
		   System.exit(1);
	   }
	}
	public void Holderdetails()
	{
		System.out.print("\u001B[38;5;198m"+"			Enter the Card Holder FullName: ");
		Name=in.nextLine();
		Mobilenumber();
		//Password();
		//Birthdate();
		System.out.println("	................................................................");
		Timedelay();
		PrintCard();
	}
}
class Atmfunction extends Atmcard
{
	
	private int ch,bal,dep;
	private boolean f=true;
	Scanner sc=new Scanner(System.in);
	public void Printrecipt()
	{
		LocalDate curDate = LocalDate.now();
		LocalDateTime now = LocalDateTime.now();
		 System.out.println("\u001B[38;2;178;34;34m"+"			.....................................................");
		System.out.println("\u001B[38;5;196m"+"				 Full Name:"+Name);
		System.out.println("			 Card Number:xxxxxxxxx"+randomnumber[3]);
		System.out.println("                         Mobile Number:"+Mobile);
		System.out.println("			 Balance:"+Balance);
		System.out.println("			 Date:"+curDate);
		System.out.println("			 Time:"+now);
	  System.out.println("\u001B[38;2;178;34;34m"+"		    	.....................................................");
	}
	public void Recipt()
	{
		System.out.println("\u001B[34m"+"\n				Recipt....");
		System.out.println("\u001B[32m"+"				  Yes(Press1) No(Press2)");
		 System.out.print("\u001B[34m"+"          → ");
		ch=sc.nextInt();
		if(ch==1)
		{
			Printrecipt();
			Exit();
		}
		else
		{
			Exit();
		}
	}
	public void Exit()
	{
		System.out.println("\u001B[38;5;208m"+"				    Progress Continue.....");
		System.out.println("			    Yes(press1) No(Press2)");
		System.out.print("\u001B[34m"+"          → ");
		ch=sc.nextInt();
		if(ch==1)
		{
			f=true;
		}
		else
		{
			f=false;	
			System.out.println("\u001B[31m"+"					Thank You");
			System.exit(1);
		}
	}
	public void Balancecheck()
	{
		System.out.println("\u001B[38;5;206m"+"\n			   Your Balance is :"+Balance+"\n");
	}
	public void Withdrow()
	{
		System.out.print("\u001B[32m"+"				Enter the Withdrow Balance:");
		bal=sc.nextInt();
		if(Balance>=bal && bal>=100 && (bal%100)==0)
		{
			Balance=Balance-bal;
			System.out.println("\u001B[31m"+"\n			.......Withdrow Suscessful.......");
		}
		else if(bal<=100)
		{
			System.out.println("\u001B[31m"+"				  You Not Withdrow Monoy");
		}
		else if(bal%100!=0)
		{
			System.out.println("\u001B[31m"+"				  You Not Withdrow Monoy");
		}
		else
		{
			System.out.println("\u001B[31m"+"				     Insaficiant Balance");
			Allfuction();
		}
	}
	public void Diposit()
	{
		System.out.print("		   	Enter the the Diposit Money:");
		dep=sc.nextInt();
		if(dep<=100000 && dep>=100 && (dep%100)==0)
		{
			Balance+=dep;
			System.out.println("\u001B[31m"+"\n		     .......Diposit Sucessful......");
		}
		else if(dep<=100)
		{
			System.out.println("\u001B[31m"+"			      Your Ammount is Low! Not add Manay");
		}
		else if(dep%100!=0)
		{
			System.out.println("\u001B[31m"+"				Ammount is Not deposit");
		}
		else
		{
			System.out.println("\u001B[31m"+"			     Your ammount is High! Not add Monany");
		}
	}
	public void Allfuction()
	{
		while(f)
		{
			System.out.println("\u001B[31m"+"\n	................................................................");
			System.out.println("\u001B[38;5;208m"+" 		 Withdrow(Press1)        Dedosit(Press2)");
			System.out.println("  		  Balance Check(Press3)   Exit(press4)");
			 System.out.println("\u001B[31m"+"		...............................................................");
			 System.out.print("\u001B[34m"+"          → ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					Withdrow();
					Recipt();
					break;
				case 2:
					Diposit();
					//Recipt();
					Exit();
					break;
				case 3:
					Balancecheck();
					Exit();
					break;
				case 4:
					f=false;
					System.out.println("\u001B[31m"+"					Thank You");
					System.exit(1);
				default :
					System.out.println("                             Invalid Option");
					
			}
		}
	}
}
class Check extends Atmfunction
{
	private boolean dec=true;
	public void valid()
	{
		Scanner sc=new Scanner(System.in);
		while(dec)
		{
			System.out.println("\u001B[38;5;208m"+"		...............................................................");
			System.out.println("		You Have Card(Press1) You Have Not Card(Press2)");
			System.out.println("	...............................................................");
			int ch;
			System.out.print("\u001B[34m"+"          → ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					valid1();
					Allfuction();
					break;
				case 2:
					Holderdetails();
					break;
			}
		}
	}
}
public class AtmProject {

	public static void main(String[] args)
	{
		System.out.println("\u001B[32m"+"				   ....Welcome To....."+"\u001B[0m");
		System.out.println("\u001B[34m"+"		      	  	The Hitachi ATM Machine"+"\u001B[0m");
		Check c1=new Check();
		c1.valid();
		
	}

}

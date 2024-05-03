import java.util.*;

public class atminterface 
{
  static int balance=0;
  static List<String> TransactionHistory= new ArrayList<>();
  
 
  public static void main(String args[])
  {
	Scanner sc= new Scanner(System.in);
    System.out.println("---------------Welcome to ATM----------------");
    int choice;
    
    try
    {
      System.out.println("Enter Your User Id: ");
      String user_id=sc.next();
      System.out.println("Enter Your User Pin: ");
      int user_pin=sc.nextInt();
    }
    catch(InputMismatchException e)
    {
	  System.out.println("Something went Wrong!");
    }
    
    do
    {
      System.out.println("-----------------------------------------------------------------------");
	  System.out.println("PLEASE CHOOSE SERVICES");
	  System.out.println("1. Deposit");
	  System.out.println("2. Withdraw");
	  System.out.println("3. Transfer Money");
	  System.out.println("4. Transaction History");
	  System.out.println("5. Exit");
	  System.out.println("-----------------------------------------------------------------------");

	  choice=sc.nextInt();
	  switch(choice)
	  {
	    case 1:
	           atminterface.deposit();
		       break;
		  
	    case 2:
		       atminterface.withdraw();
		       break;
		       
	    case 3:
	       	   atminterface.transfer();
		       break;
		       
	    case 4:
		       atminterface.history();
		       break;
		
	    case 5:
	           System.out.println("Exit!");
	       	   break;
		default:
		       System.out.println("Something went wrong!");
		}
     }	
     while(choice!=5);
  }

  static void deposit()
  {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the Amount to Deposit: ");
	int deposit=sc.nextInt();
	System.out.println("Do You want to Continue? Yes or No");
	String opinion=sc.next();
	if(opinion.equalsIgnoreCase("YES"))
	{		
	  balance=balance+deposit;
	  System.out.println("Deposited Amount Rs."+deposit+"/- Successfully!");
	  TransactionHistory.add("Deposited Amount Rs."+deposit+"/-");
	}
	else if(opinion.equalsIgnoreCase("NO"))
	{
		return;
	}
  }

  static void withdraw()
  {
	try
	{
	  Scanner sc= new Scanner(System.in);
	  System.out.println("Enter the Amount to Withdraw: ");
	  int withdraw=sc.nextInt();
	  if(balance>=withdraw)
	  {
		System.out.println("Do You want to Continue? Yes or No");
		String opinion=sc.next();
		
		if(opinion.equalsIgnoreCase("YES"))
		{
	      balance=balance-withdraw;	
	      System.out.println("Withdrawn Amount Rs."+withdraw+"/- Successfully!");
	      TransactionHistory.add("Withdrawn Amount Rs."+withdraw+"/-");
	    }
		else if(opinion.equalsIgnoreCase("NO"))
		{
			return;
		}
		
       }
	else
	{
	 System.out.println("Your Account balance is insufficient to withdraw!"); 
	}
	}
	catch(InputMismatchException e)
	{
		System.out.println("Something went Wrong!");
	}
  }
  static void transfer()
  {
	try
	{
	  Scanner sc= new Scanner(System.in);
	  System.out.println("Enter beneficier's Bank Account Number: ");
	  int acc_no=sc.nextInt();
	  System.out.println("Enter beneficier's Bank Name: ");
	  String bank_name=sc.next();
	  System.out.println("Enter the Amount to Transfer: ");
	  int trans_amt=sc.nextInt();
	  if(balance>=trans_amt)
	  {  
		System.out.println("Do You want to Continue? Yes or No");
		String opinion=sc.next();
		
		if(opinion.equalsIgnoreCase("YES"))
		{
	      balance=balance-trans_amt;	
	      System.out.println("Transferred Amount Rs."+trans_amt+"/-Successfully!");
	      TransactionHistory.add("Transferred Amount Rs."+trans_amt+"/-");
	   	}
		else if(opinion.equalsIgnoreCase("NO"))
		{
		  return;
		}
		
	}
	else
	{
	  System.out.println("Your Account balance is insufficient to transfer the amount!"); 
	}
	}
	catch(InputMismatchException e)
	{
	  System.out.println("Something went Wrong!");
	}
  }
  static void history()
  {
    Scanner sc= new Scanner(System.in);
	System.out.println("Transaction History: ");
	System.out.println(TransactionHistory);
  }
}

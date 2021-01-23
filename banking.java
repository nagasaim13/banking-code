import java.util.*;
class banking
{
	public static void main(String args[])
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("enter customer name and id:");
		String name=sc.nextLine();
		String id=sc.nextLine();
		BankAccount obj=new BankAccount(name,id);
			obj.showmenu();
	}
}
class BankAccount
{
	int balance;
	int previous_transaction;
	String customer_name;
	String customer_id;
	BankAccount(String c_name,String c_id)
	{
		customer_name=c_name;
		customer_id=c_id;
	}
	void deposit(int dep_amount)
	{
		if(dep_amount!=0)
		{
			balance=balance+dep_amount;
			previous_transaction=dep_amount;
		}
	}
	void withdraw(int wdraw_amount)
	{
		if(wdraw_amount!=0)
		{
			balance=balance-wdraw_amount;
			previous_transaction=-wdraw_amount;
		}
	}
	void get_prev_transactions()
	{
		if(previous_transaction>0)
		{
			System.out.println("deposited amount: "+previous_transaction);
		}
		else if(previous_transaction<0)
		{
			System.out.println("withdrawn amount is: "+Math.abs(previous_transaction));
		}
		else
		{
			System.out.println("no transaction found");
		}
	}
	void showmenu()
	{
		char option='\0';
		Scanner sc=new Scanner(System.in);

		System.out.println("welcome: "+customer_name);
		System.out.println("your id is "+customer_id);
		System.out.println("\n");
		System.out.println("A.check balane:");
		System.out.println("B.deposit:");
		System.out.println("C.withdraw:");
		System.out.println("D.previous transaction");
		System.out.println("E.EXIT:");

		do
		{
			System.out.println("*****************************");
			System.out.println("Enter an option:");
			System.out.println("*****************************");
			option=sc.next().charAt(0);
			System.out.println("\n");
			switch(option)
			{
				case 'A':
					System.out.println("*********************");
					System.out.println("balance:"+balance);
					System.out.println("**********************");
					System.out.println("\n");
					break;
				case 'B':
					System.out.println("*********************");
					System.out.println("Enter an amount to deposit:");
					int amount=sc.nextInt();
					deposit(amount);
					System.out.println("**********************");
					System.out.println("\n");
					break;
				case 'C':
					System.out.println("*********************");
					System.out.println("Enter an amount to withdraw");
					int amount2=sc.nextInt();
					withdraw(amount2);
					System.out.println("**********************");
					System.out.println("\n");
					break;
				case 'D':
					System.out.println("*********************");
					get_prev_transactions();
					System.out.println("**********************");
					System.out.println("\n");
					break;
				case 'E':
					System.out.println("*********************");
					break;
				default:
					System.out.println("invalid option!please enter other option");
					break;
			}
		}while(option!='E');
		System.out.println("Thanq for using our services");
	}
}

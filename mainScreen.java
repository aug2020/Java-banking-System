package eecs2011Assignement1;

import java.io.IOException;
import java.util.*;

public class mainScreen {

	
	ArrayList<checkingAccount> cha = new ArrayList<>(); //creating 3 arraylist to store the different account types
	ArrayList<creditAccount> cra = new ArrayList<>();
	ArrayList<demandAccount> dma = new ArrayList<>();
	//creation of variables used in program
	public int hehe = 0;
	public int sin = 0;
	public int selection = 0;
	public double amt=0,loan=0;
	public int transfer=0;
	public int num1 = 0;
	public int overdraft=0;
	public int num=0;
	private double balance=0.0;
	public int num2 = 0;
	public String name;
	public Scanner sc = new Scanner(System.in);
	public int lol=0;
	public void caller() throws IOException 
	{
		this.num=0;
		//printing out the home screen and options
		while (this.num!=1 && this.num!=2 && this.num!=3) {
			System.out.println("-----------------------------");
			System.out.println("|     A&K BANKING SYSTEM    |");
			System.out.println("-----------------------------");
			System.out.println("1. NEW CUSTOMER REGISTER NOW - PRESS 1");
			System.out.println("2. EXISTING CUSTOMER - PRESS 2");
			System.out.println("3. EXIT - PRESS 3");
			try {
				this.num = sc.nextInt();
			} catch (InputMismatchException e) {

			}
		}
		//calling the different options that the user selects
			if (this.num == 1) {
				this.caller1();
			} else if (this.num == 2) {
				this.caller2();
			} else if (num == 3) {
				Runtime.getRuntime().exit(0);
			} else if (num != 1 || num != 2 || num != 3) {
				System.out.println("Please enter a listed selection");
			}
		
		
	}
	
	public void caller1() throws IOException {
		// new screen if the user selects to create a new account
		while (this.num1 != 1 && this.num1 != 2 && this.num1 != 3 && this.num1 != 4) {
			System.out.println("-----------------------------");
			System.out.println("|  A&K NEW ACCOUNT CREATION |");
			System.out.println("-----------------------------");
			System.out.println("1. CHECKINGS ACCOUNT - PRESS 1");
			System.out.println("2. CREDIT ACCOUNT CUSTOMER - PRESS 2");
			System.out.println("3. DEMAND LOAN ACCOUNT - PRESS 3");
			System.out.println("4. EXIT - PRESS 3");
			try {
				this.num1 = sc.nextInt();
			} catch (InputMismatchException e) {
				this.num1 = 0;
			}
		}
///////////////// CHECKING ACCOUNT CREATION /////////////////////////////	
		//creating a checkings account if selected
		if (this.num1 == 1) {
			while (this.hehe == 0) {
				Scanner sc2 = new Scanner(System.in);
					
					try {
						System.out.print("Enter first name: ");
						this.name=sc2.next();
						
						System.out.print("Enter SIN: ");
						this.sin=sc2.nextInt();
						
						System.out.print("Enter initial Balance: ");
						this.balance=sc2.nextDouble();
						System.out.print("SELECT OVERDRAFT OPTION: (1) NO OVERDRAFT , (2) PAY PER USE, (3) MONTHY FIXED FEE ");
						this.overdraft=sc.nextInt();
						this.cha.add(new checkingAccount(this.name,this.sin,this.balance,this.overdraft));
						System.out.println("Account Successfully created returning to home Screen"); 
						this.hehe=1;
						
					} catch (InputMismatchException e) {
						System.out.println("Please enter a valid name and SIN");
						this.hehe=0;
					}
			}
			
			this.num1=0;
			this.hehe=0;
			this.caller();
		}
	///////////////////	CREDIT ACCOUNT CREATION /////////////////////////////
	//creating a credit account if selected
		if (this.num1 == 2) {
			
			while (this.hehe == 0) {
				Scanner sc2 = new Scanner(System.in);
					
					try {
						System.out.print("Enter first name: ");
						this.name=sc2.next();
						
						System.out.print("Enter SIN: ");
						this.sin=sc2.nextInt();
						
						System.out.print("Enter initial Balance: ");
						this.balance=sc2.nextDouble();
						System.out.print("SELECT OVERDRAFT OPTION: (1) NO OVERDRAFT , (2) PAY PER USE, (3) MONTHY FIXED FEE ");
						this.overdraft=sc.nextInt();
						System.out.print("Enter Credit limit: ");
						double lim =sc2.nextDouble();
						this.cra.add(new creditAccount(this.name,this.sin,this.balance,this.overdraft,lim));
						System.out.println("Account Successfully created returning to home Screen"); 
						this.hehe=1;
						
					} catch (InputMismatchException e) {
						System.out.println("Please enter a valid name and SIN");
						this.hehe=0;
					}
			}
			
			this.num1=0;
			this.hehe=0;
			this.caller();	
		}
		/////////////// DEMAND LOAN CREATION ////////////////
		//creating a demand loan account if selected 

		if (this.num1 == 3) {
			
			while (this.hehe == 0) {
				Scanner sc2 = new Scanner(System.in);
					
					try {
						System.out.print("Enter first name: ");
						this.name=sc2.next();
						
						System.out.print("Enter SIN: ");
						this.sin=sc2.nextInt();
						
						System.out.print("Enter Loan to take out: ");
						this.loan=sc2.nextDouble();
						System.out.print("SELECT OVERDRAFT OPTION: (1) NO OVERDRAFT , (2) PAY PER USE, (3) MONTHY FIXED FEE ");
						this.overdraft=sc.nextInt();
						this.dma.add(new demandAccount(this.name,this.sin,this.loan,this.overdraft));
						System.out.println("Account Successfully created returning to home Screen"); 
						this.hehe=1;
						
					} catch (InputMismatchException e) {
						System.out.println("Please enter a valid name and SIN");
						this.hehe=0;
					}
			}
			
			this.num1=0;
			this.hehe=0;
			this.caller();	
		}
		
		
		
	}
	
	public void caller2() throws IOException {
		//Outputing an already created account if it was not created the a prompt will display telliing the user to create an account
		while (this.num2 != 1) 
		{
			System.out.println("-----------------------------");
			System.out.println("|    A&K EXISTING ACCOUNT   |");
			System.out.println("-----------------------------");
			System.out.println("Please enter the SIN that is Associated to your Account");
			System.out.print("SIN:");
			try {
				this.sin = sc.nextInt();
				if(this.cha.isEmpty()==true && this.cra.isEmpty()==true&& this.dma.isEmpty()==true)
				{
					System.out.println("Customer has not been created please create an account");
					this.caller();
				}
				if(this.cha.isEmpty()!=true || this.cra.isEmpty()!=true|| this.dma.isEmpty()!=true)
				{
					this.num2=1;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid SIN please Try again");
			}
	}
		
	//////////CHECKINGS ACCOUNT ////////////
		//Output an Exsisting checkings account
		for(int i=0;i<this.cha.size();i++)
		{
			if(this.cha.get(i).getSIN()!= this.sin)
			{
				System.out.println("Customer has not been created please create an account");
				this.num2=0;
				this.caller();
			}
			//transaction options for the user
			if(this.cha.get(i).getSIN()== this.sin)
			{
				System.out.println("SIN : "+cha.get(i).getSIN());
				System.out.println("NAME : "+cha.get(i).getName());
				System.out.println("BALANCE : "+cha.get(i).getBalance());
				System.out.println("ACCOUNT TYPE : "+cha.get(i).getAccountype());
				System.out.println("OVER DRAFT TYPE : "+cha.get(i).setOverdraftOption(this.overdraft));
				
				System.out.println("-----------------------------");
				System.out.println("|       ACCOUNT OPTION      |");
				System.out.println("-----------------------------");
				System.out.println("1. WITHDRAW MONEY - PRESS 1");
				System.out.println("2. DEPOSIT MONEY  - PRESS 2");
				System.out.println("3. TRANSFER MONEY - PRESS 3");
				System.out.println("4. EXIT - PRESS 4");
				this.selection =sc.nextInt();
				
				if(this.selection==1)
				{
					System.out.println(" WITHDRAW AMOUNT: ");
					this.amt=sc.nextDouble();
					if(this.amt>this.cha.get(i).getBalance() && this.cha.get(i).getOverdraft() == 1)
					{
						System.out.println(" Non-Sufficient Funds (NSF) of $40 has been applied withdrawel declined");
						this.cha.get(i).withdrawAmount(40.0);
						this.caller2();
					}
					else if(this.amt>this.cha.get(i).getBalance() &&  this.cha.get(i).getOverdraft() == 2)
					{
						System.out.println(" Pay per use fee of $5 has been applied");
						this.cha.get(i).withdrawAmount(amt);
						this.caller2();
					}
					else if(this.amt>this.cha.get(i).getBalance() &&  this.cha.get(i).getOverdraft()== 3)
					{
						System.out.println("A monthly fee of 4.00 will be charged at the end of the month ");
						this.cha.get(i).withdrawAmount(amt);
						this.caller2();
					}
				}
					if(this.selection==2)
					{
						System.out.println(" DEPOSIT AMOUNT: ");
						this.amt=sc.nextDouble();
						this.cha.get(i).depositAmount(amt);
						System.out.println(this.amt+" has been deposited");
						this.caller2();
					}
					if (this.selection==3)
					{
						System.out.println("TRANSFER SIN: ");
						this.transfer=sc.nextInt();
						System.out.println("TRANSFER AMOUNT: ");
						this.amt=sc.nextDouble();
						if(this.amt>=this.cha.get(i).getBalance() &&  this.cha.get(i).getOverdraft() == 1)
						{
							System.out.println(" Non-Sufficient Funds (NSF) of $40 has been applied Transfer declined");
							this.cha.get(i).withdrawAmount(40.0);
							this.caller2();
						}
						else if(this.amt>=this.cha.get(i).getBalance() &&  this.cha.get(i).getOverdraft() == 2)
						{
							System.out.println(" Pay per use fee of $5 has been applied");
							this.cha.get(i).withdrawAmount(amt);
							this.caller2();
						}
						else if(this.amt>=this.cha.get(i).getBalance() &&  this.cha.get(i).getOverdraft() == 3)
						{
							System.out.println("A monthly fee of 4.00 will be charged at the end of the month ");
							this.cha.get(i).withdrawAmount(amt);
							this.caller2();
						}
						else
						{
							System.out.println("AMOUNT WAS TRANSFERED");
							this.cha.get(i).withdrawAmount(amt);
							this.caller2();
						}
					}
					if (this.selection==4)
					{
						this.caller();
					}
			}
		}
		////////////// CREDIT ACCOUNT ////////////////////
		//Output an Exsisting checkings account
		for(int i=0;i<this.cra.size();i++)
		{
			if(this.cra.get(i).getSIN()!= this.sin)
			{
				System.out.println("Customer Sin has not been created please create an account");
				this.num2=0;
				this.caller();
			}
			//transactions operation for the user
			if(this.cra.get(i).getSIN()== this.sin)
			{
				System.out.println("SIN : "+cra.get(i).getSIN());
				System.out.println("NAME : "+cra.get(i).getName());
				System.out.println("BALANCE : "+cra.get(i).getBalance());
				System.out.println("ACCOUNT TYPE : "+cra.get(i).getAccountype());
				System.out.println("OVER DRAFT TYPE : "+cra.get(i).setOverdraftOption(this.overdraft));
				System.out.println("CREDIT LIMIT: "+cra.get(i).getLimit());
				
				System.out.println("-----------------------------");
				System.out.println("|       ACCOUNT OPTION      |");
				System.out.println("-----------------------------");
				System.out.println("1. WITHDRAW MONEY - PRESS 1");
				System.out.println("2. DEPOSIT MONEY  - PRESS 2");
				System.out.println("3. TRANSFER MONEY - PRESS 3");
				System.out.println("4. EXIT - PRESS 4");
				this.selection =sc.nextInt();
				
				
				
				if(this.selection==1)
				{
					System.out.println(" WITHDRAW AMOUNT: ");
					this.amt=sc.nextDouble();
					if(this.amt>=this.cra.get(i).getBalance() && this.cra.get(i).getLimit()>1000 && this.amt>this.cra.get(i).getLimit() )
					{
						System.out.println("withdrawal declined, Credit Exceed Limit (CLE) penalty will be charged.");
						this.cra.get(i).withdrawAmount(29.0);
						this.caller2();
					}
					 if(this.amt>=this.cra.get(i).getBalance() && this.amt- this.cra.get(i).getLimit()<=0 && this.cra.get(i).getLimit()<=1000)
					{
						System.out.println("withdrawal declined, Credit Exceed Limit (CLE) penalty will not be charged.");
						this.caller2();
					}
					else
					{
						this.cra.get(i).withdrawAmount(amt);
						this.caller2();
					}
				}
					if(this.selection==2)
					{
						System.out.println(" DEPOSIT AMOUNT: ");
						this.amt=sc.nextDouble();
						this.cra.get(i).depositAmount(amt);
						System.out.println(this.amt+" has been deposited");
						this.caller2();
					}
					if (this.selection==3)
					{
						System.out.println("TRANSFER SIN: ");
						this.transfer=sc.nextInt();
						System.out.println("TRANSFER AMOUNT: ");
						this.amt=sc.nextDouble();
						if(this.amt>this.cra.get(i).getBalance() && this.cra.get(i).getLimit()>1000 && this.amt>this.cra.get(i).getLimit() )
						{
							System.out.println("withdrawal declined, Credit Exceed Limit (CLE) penalty will be charged.");
							this.cra.get(i).withdrawAmount(29.0);
							this.caller2();
						}
						else if(this.amt>this.cra.get(i).getBalance() && this.amt > this.cra.get(i).getLimit() && this.cra.get(i).getLimit()<=1000)
						{
							System.out.println("withdrawal declined, Credit Exceed Limit (CLE) penalty will not be charged.");
							this.caller2();
						}
						else
						{
							System.out.println(this.amt+" has been deposited");
							this.cra.get(i).withdrawAmount(amt);
							this.caller2();
						}
					}
					if (this.selection==4)
					{
						this.caller();
					}
		}
		}
		
	////DEMAND LOAN ACCOUNT/////////////	
		//Output an Exsisting Demand account
		for(int i=0;i<this.dma.size();i++)
		{
			if(this.dma.get(i).getSIN()!= this.sin)
			{
				System.out.println("Customer has not been created please create an account");
				this.num2=0;
				this.caller();
			}
			//// Transaction operation for the user
			if(this.dma.get(i).getSIN()== this.sin)
			{
				System.out.println("SIN : "+dma.get(i).getSIN());
				System.out.println("NAME : "+dma.get(i).getName());
				System.out.println("LOAN : "+dma.get(i).getLoan());
				System.out.println("ACCOUNT TYPE : "+dma.get(i).getAccountype());
				System.out.println("OVER DRAFT TYPE : "+dma.get(i).setOverdraftOption(this.overdraft));
				
				System.out.println("-----------------------------");
				System.out.println("|       ACCOUNT OPTION      |");
				System.out.println("-----------------------------");
				System.out.println("1. WITHDRAW MONEY - PRESS 1");
				System.out.println("2. DEPOSIT MONEY  - PRESS 2");
				System.out.println("3. TRANSFER MONEY - PRESS 3");
				System.out.println("4. EXIT - PRESS 4");
				this.selection =sc.nextInt();
				
				if(this.selection==1)
				{
					System.out.println(" WITHDRAW AMOUNT: ");
					this.amt=sc.nextDouble();
					System.out.println("AMOUNT "+amt+" HAS BEEN WITHDRAWN");
					this.dma.get(i).withdrawAmount(amt);
						this.caller2();
				}
					if(this.selection==2)
					{
						System.out.println(" DEPOSIT AMOUNT: ");
						this.amt=sc.nextDouble();
						this.dma.get(i).depositAmount(amt);
						System.out.println(this.amt+" has been deposited");
						this.caller2();
					}
					if (this.selection==3)
					{
						System.out.println("TRANSFER SIN: ");
						this.transfer=sc.nextInt();
						System.out.println("TRANSFER AMOUNT: ");
						this.amt=sc.nextDouble();
							System.out.println("AMOUNT WAS TRANSFERED");
							this.dma.get(i).withdrawAmount(amt);
							this.caller2();
					}
					if (this.selection==4)
					{
						this.caller();
					}
			}
		}
		
		
			
}
}


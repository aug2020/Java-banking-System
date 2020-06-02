package eecs2011Assignement1;

import java.io.IOException;

public class demandAccount {
	public String name;
	public int sin;
	public double loan;
	public int overdraft;
	public int lim;
	public accountLog acl = new accountLog();
	//creating credit account
	public demandAccount(String name, int sin, double loan, int overdraft) throws IOException
	{
		this.name=name;
		this.sin=sin;
		this.loan=loan;
		this.overdraft=overdraft;
		this.acl.processAccountLogEndOfDay("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"NONE");
		this.acl.processAccountLogEndOfMonth("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"NONE");
	}
	//withraw operation
	public double withdrawAmount(double wmt) throws IOException
	{
		this.loan=this.loan-wmt;
		this.acl.processAccountLogEndOfDay("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"WITHDRAWL");
		this.acl.processAccountLogEndOfMonth("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"WITHDRAWL");
		return this.loan;
	}
	//deposit operation
	public double depositAmount(double dmt) throws IOException
	{
		this.acl.processAccountLogEndOfDay("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"DEPOSIT");
		this.acl.processAccountLogEndOfMonth("Demand Loan Account", this.name, this.sin, this.loan,this.overdraft,"DEPOSIT");
		return -1;
	}
	//creating an account
	public void createAccount(String name, int sin,double loan)
	{
		this.name=name;
		this.sin=sin;
		this.loan=loan;
	}
	//suspend account
	public void suspendAccount(int sin)
	{
		
	}
	//reload the account to arraylist
	public void recreateAccount(int sin)
	{
		
	}
	//return loan
	public double getLoan()
	{
		return this.loan;
	}
	//return name
	public String getName()
	{
		return this.name;
	}
	//return SIN
	public int getSIN()
	{
		return this.sin;
	}
	//return overdraft
	public int getOverdraft()
	{
		
		return this.overdraft;
	}
	//delete account
	public void terminateAccount(int sin)
	{
		
	}
	//creating overdraft
	public String setOverdraftOption(int num)
	{
		String over="";
		if (num==1)
		{
			this.overdraft=1;
			over = "(1) NO OVERDRAFT";
		}
		if (num==2)
		{
			this.overdraft=2;
			over = "(2) PAY PER USE";
		}
		if (num==3)
		{
			this.overdraft=3;
			over ="(3) MONTHY FIXED FEE";
		}
		
		return over;
	}
	//return credit limit
	public void setLimit(int lim)
	{
		this.lim=lim;
	}
	//transfer money
	public void transferAmount(int amt , int sin)
	{
		
	}
	@Override
	//equals method to compare 
	public boolean equals(Object obj)
	{
		if(this == obj )
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(this.getClass()!= obj.getClass())
		{
			return false;
		}
		
		checkingAccount other = (checkingAccount) obj;
		
		return this.getSIN() == other.getSIN();
	}
	//return account type
	public String getAccountype()
	{
		return "Demand Loan Account";
	}
}

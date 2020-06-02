package eecs2011Assignement1;

import java.io.IOException;

public class creditAccount {

	public String name;
	public int sin;
	public double balance=0.0;
	public int overdraft;
	public double lim;
	accountLog acl = new accountLog();
	//creating credit account
	public creditAccount(String name, int sin, double bal, int overdraft,double lim)throws IOException
	{
		this.name=name;
		this.sin=sin;
		this.balance=bal;
		this.overdraft=overdraft;
		this.lim=lim;
		this.acl.processAccountLogEndOfDay("Credit Account", this.name, this.sin, this.balance,this.overdraft,"NONE");
		this.acl.processAccountLogEndOfMonth("Credit Account", this.name, this.sin, this.balance,this.overdraft,"NONE");
	}
	//withraw operation
	public double withdrawAmount(double wmt) throws IOException
	{
		this.balance=this.balance-wmt;
		this.acl.processAccountLogEndOfDay("checkings Account", this.name, this.sin, this.balance,this.overdraft,"WITHDRAWEL");
		this.acl.processAccountLogEndOfMonth("checkings Account", this.name, this.sin, this.balance,this.overdraft,"WITHDRAWL");
		return this.balance;
	}
	//deposit operation
	public double depositAmount(double dmt) throws IOException
	{
		this.balance=this.balance+dmt;
		this.acl.processAccountLogEndOfDay("checkings Account", this.name, this.sin, this.balance,this.overdraft,"DEPOSIT");
		this.acl.processAccountLogEndOfMonth("checkings Account", this.name, this.sin, this.balance,this.overdraft,"DEPOSIT");
		return this.balance;
	}
	//creating an account
	public void createAccount(String name, int sin,double bal)
	{
		this.name=name;
		this.sin=sin;
		this.balance=bal;
	}
	//suspend account
	public void suspendAccount(int sin)
	{
		
	}
	public void recreateAccount(int sin)
	{
		
	}
	//return balance
	public double getBalance()
	{
		return this.balance;
	}
	//return name
	public String getName()
	{
		return this.name;
	}
	//retun SIN
	public int getSIN()
	{
		return this.sin;
	}
	//return overdraft operation
	public int getOverdraft()
	{
		
		return this.overdraft;
	}
	//delete account
	public void terminateAccount(int sin)
	{
		
	}
	//setting overdraft
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
	//setting credit limit
	public void setLimit(double lim)
	{
		this.lim=lim;
	}
	//return account limit
	public double getLimit()
	{
		return this.lim;
	}
	public void transferAmount(int amt , int sin)
	{
		
	}
	@Override
	//equals operation
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
		return "Credit Account";
	}
}

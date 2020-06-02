package eecs2011Assignement1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class accountLog {
	public String accounttype;
	public String name;
	public int sin,overdraft;
	public double balance;
	public double loan;
	public String transaction;
	
	public accountLog()throws IOException
	{
		
	}
	public void sortAccountLog(accountLog log[], int sin)
	{
		//insertion sort to sort account log by sin
		    int i, j;
			accountLog key;  
		    for (i = 1; i < sin; i++) 
		    {  
		        key = log[i];  
		        j = i - 1;  
		        while (j >= 0 && log[j].sin > key.sin) 
		        {  
		            log[j + 1] = log[j];  
		            j = j - 1;  
		        }  
		        log[j + 1] = key;  
		    }   
	}
	
	public void processAccountLogEndOfDay(String accounttype,String name,int sin, double balance,int overdraft,String transaction) throws IOException
	{
		//creating buffer writer to write account info and transaction to file daylog
	    BufferedWriter bW = new BufferedWriter(new FileWriter("Daylog",false)); 
		this.accounttype=accounttype;
		this.name=name;
		this.sin=sin;
		this.balance=balance;
		this.transaction=transaction;
		this.overdraft=overdraft;
		bW.write("NAME: "+this.name+"\n");
		bW.write("SIN: "+this.sin+"\n");
		bW.write("BALANCE: "+this.balance+"\n");
		bW.write("TRANSACTION: "+this.transaction+"\n");
		bW.write("OVERDRAFT: "+this.overdraft+"\n");
		bW.write("ACCOUNT TYPE: "+this.accounttype+"\n");
		bW.close();
	}
		
	public void processAccountLogEndOfMonth(String accounttype,String name,int sin, double balance,int overdraft,String transaction) throws IOException
	{
		//creating buffer writer to write account info and transaction to file Monthlog
		 BufferedWriter bW = new BufferedWriter(new FileWriter("MonthLog",true)); 
			this.accounttype=accounttype;
			this.name=name;
			this.sin=sin;
			this.balance=balance;
			this.transaction=transaction;
			this.overdraft=overdraft;
			bW.write("\n"+"NAME: "+this.name+"\n");
			bW.write("SIN: "+this.sin+"\n");
			bW.write("BALANCE: "+this.balance+"\n");
			bW.write("TRANSACTION: "+this.transaction+"\n");
			bW.write("OVERDRAFT: "+this.overdraft+"\n");
			bW.write("ACCOUNT TYPE: "+this.accounttype+"\n");
			bW.close();
		
	}
			
			public void saveAccountLog() throws IOException
			{
				//saving the account log to the system.
				 BufferedWriter bW = new BufferedWriter(new FileWriter("MonthLog",true)); 
				 bW.write("");
			}
				
		public void retrieveAccountLog() throws IOException
		{
			//retrieving the account log if called upon.
			  BufferedReader br = new BufferedReader(new FileReader("dayLog")); 
			  String file; 
			  while ((file = br.readLine()) != null) 
			    System.out.println(file); 
			  }
		}

	


package com.ibm.exception;

public class UnitRate
{
	public  void calculatePerUnitRate()
	{
		int qty=20, rate=0,punit=0;
		try
		{
			punit=qty/rate;
		}
		catch(ArithmeticException ae)
		
		{  
			System.out.println("The product rate cannot be Zero, So Per Unit Rate Displayed Below is Invalid");
		} 
		System.out.println("The Per Unit Rate is = "+punit);
	}
	public static void main(String[] args) {
		new UnitRate().calculatePerUnitRate();
	}
}

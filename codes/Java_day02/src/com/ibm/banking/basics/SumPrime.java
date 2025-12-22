package com.ibm.banking.basics;

public class SumPrime {
	public static boolean isPrime(int n)
	{
		
		
	int count=0;
	for(int i=1;i<=n;i++)
	{
		if(n%i==0)
			count++;
	}
	if(count==2)
		return true;
	else
		return false;
		
	}
	public static void main(String[] args) {
		int sum=0;
		int c=0,n=1;
		while(c<100)
		{
			if(isPrime(n++))
			{
				System.out.println(n);
				sum+=n;
				c++;
			}
			
		}
		System.out.println("Sum="+sum);
	}
}

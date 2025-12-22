package com.ibm.banking.basics;
import java.util.Scanner;


public class BinaryAddition {
	public static void main(String[] args) {
		
		int n1,n2;
		System.out.println("Enter 2 numbers to add:");
		Scanner sc=new Scanner(System.in);
		n1=sc.nextInt();
		n2=sc.nextInt();
		int[] sum=new int[20];
		int i=0,remainder=0;
		while(n1!=0 && n2!=0)
		{
			sum[i++]=(n1%10+n2%10+remainder)%2;
			remainder=(n1%10+n2%10+remainder)/2;
			n1/=10;
			n2/=10;
			
		}
		if(remainder!=0)
			sum[i++]=remainder;
		--i;
		while(i>=0)
		{
			System.out.print(sum[i--]);
		}
				
		sc.close();
	}
	
	
}

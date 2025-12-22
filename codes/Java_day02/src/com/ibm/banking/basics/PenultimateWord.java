package com.ibm.banking.basics;
import java.util.*;

public class PenultimateWord {
	public static void main(String[] args) {
		List<String> str=new ArrayList<String>();
		String input;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string:");
		input=sc.nextLine();
		StringTokenizer st1=new StringTokenizer(input," ");
		
		while(st1.hasMoreTokens())
		{
			str.add(st1.nextToken());
		}
		System.out.println(str.get(str.size()-2));
		sc.close();
		
	}
}

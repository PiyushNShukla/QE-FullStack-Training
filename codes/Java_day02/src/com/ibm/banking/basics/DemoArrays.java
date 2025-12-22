package com.ibm.banking.basics;

public class DemoArrays {
	int[] intArr;
	public void initAndPrintArray(){
		intArr=new int[5];
		for(int i=0;i<5;i++)
		{
			intArr[i]=2*i+1;
		}
		for(int i: intArr) {
			System.out.print(i+"\t");
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome");
//		new DemoArrays().initAndPrintArray();
		DemoArrays demo=new DemoArrays();
		demo.initAndPrintArray();
		// In case of calling a non static method from main we need to create the object of the
		//class and then call the method
		System.out.println("");
		for(String s: args)
		{
			System.out.print(s+" ");
		}
		
	}
}

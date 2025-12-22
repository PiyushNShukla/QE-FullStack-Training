package com.ibm.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EmployeeList {
	public static void main(String[] args) {
		
			Employee emp1=new Employee();
			emp1.setFirstName("John");
			emp1.setLastName("Doe");
			emp1.setDepartment("IT");
			emp1.setSalaryPackage(100000);
			
			Employee emp2=new Employee();
			emp2.setFirstName("Jane");
			emp2.setLastName("Smith");
			emp2.setDepartment("Finance");
			emp2.setSalaryPackage(400000);
			
			
			List<Employee> emps=Arrays.asList(emp1,emp2);
			Iterator<Employee> itr=emps.iterator();
			while(itr.hasNext())
			{
				Employee e=itr.next();
				System.out.println(e.getFirstName()+" "+e.getLastName()+" "+e.getDepartment()+" "+e.getSalaryPackage());
			}
			
		}
//		public static void getFruitList() {
//			List<String> fruits=new ArrayList<String>();
//			fruits.add("Apple");
//			fruits.add("Banana");
//			fruits.add("Strawberry");
//			fruits.add(2,"Mango");
//			fruits.addLast("Grapes");
//			fruits.addFirst("Guava");
//			
//			List<String> berries=new ArrayList<String>();
//			berries.add("Bllackberry");
//			System.out.println(berries);
//			System.out.println(fruits);
//			
//			for(String fruit: fruits)
//			{
//				System.out.println("Let us eat andd enjoy:"+fruit);
//			}
//			
//			Iterator<String> itr=fruits.iterator();
//			while(itr.hasNext())
//			{
//				System.out.println("Enjoy:"+itr.next());
//			}
//		}
	
}

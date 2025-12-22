package com.ibm.banking.basics;

public class DemoPrimitives {
	byte bVar;
	int iVar;
	public void treatBytes() {
		bVar=127;
		for(byte b=-128;b<bVar;b++)
		{
			System.out.print(b+" ");
		}
	}
	public static void main(String[] args) {
		DemoPrimitives demo=new DemoPrimitives();
		demo.treatBytes();
	}

}

package com.ibm.test;

import org.testng.annotations.Test;

public class TransferFundsTest {
  @Test
  public void verifyFundsTransferWithEnoughFunds() {
	  System.out.println("Funds transferred Successfully.. Hence validated.");
	 
  }
  @Test(dependsOnMethods = {"verifyFundsTransferWithEnoughFunds"})
  public void verifyFundsTransferWithoutEnoughFunds() {
	  System.out.println("Funds transfer failed...Add funds..");
  }
}

package com.ibm.intefaces;

import com.ibm.banking.registration.Banking;

public class EnjoyBanking implements Banking {

	@Override
	public String displayBankingOperations() {
		String banking="Corporate Banking with insurance benefits";
		System.out.println("The banking offered is-"+banking);
		return banking;
	}

	@Override
	public void useBanking() {
		
		
	}
	
}

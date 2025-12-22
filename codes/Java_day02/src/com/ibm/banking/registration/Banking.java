package com.ibm.banking.registration;

import com.ibm.intefaces.MobileBanking;
import com.ibm.intefaces.NormalBanking;

public interface Banking extends NormalBanking,MobileBanking {
	public static final String bankingType="Corporate Banking";
	public String displayBankingOperations();

}

package com.techminds.apar.poc.service;

import java.util.List;

import com.techminds.apar.poc.model.AccountPayable;

public interface AccountPayableService {
	public List<AccountPayable> getAccountPayable(String paramDate);

}

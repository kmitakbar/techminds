package com.techminds.apar.poc.service;

import java.util.List;

import com.techminds.apar.poc.model.AccountReceoveable;

public interface AccountReceiveableService {
	
	public List<AccountReceoveable> getAccountReceivable(String paramDate);

}

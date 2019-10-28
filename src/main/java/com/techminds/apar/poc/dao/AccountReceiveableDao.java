package com.techminds.apar.poc.dao;

import java.util.List;

import com.techminds.apar.poc.model.AccountReceoveable;

public interface AccountReceiveableDao {
	
	public List<AccountReceoveable> getAccountReceivable(String paramDate);

}

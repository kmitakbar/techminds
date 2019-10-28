package com.techminds.apar.poc.dao;

import java.util.List;

import com.techminds.apar.poc.model.AccountPayable;

public interface AccountPayableDao {

	public List<AccountPayable> getAccountPayable(String paramDate);
}

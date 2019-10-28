package com.techminds.apar.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techminds.apar.poc.dao.AccountPayableDao;
import com.techminds.apar.poc.model.AccountPayable;
import com.techminds.apar.poc.service.AccountPayableService;

@Service
public class AccountPayableServiceImpl implements AccountPayableService{

	@Autowired
	private AccountPayableDao dao;
	
	@Override
	public List<AccountPayable> getAccountPayable(String paramDate) {
		
		return dao.getAccountPayable(paramDate);
	}

}

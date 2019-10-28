package com.techminds.apar.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techminds.apar.poc.dao.AccountSummeryDao;
import com.techminds.apar.poc.model.AccountSummery;
import com.techminds.apar.poc.service.AccountSummeryService;

@Service
public class AccountSummeryServiceImpl implements AccountSummeryService {

	@Autowired
	private AccountSummeryDao dao;
	
	@Override
	public List<AccountSummery> getSummery() {
		
		return dao.getSummery();
	}

}

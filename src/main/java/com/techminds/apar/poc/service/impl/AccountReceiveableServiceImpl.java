package com.techminds.apar.poc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techminds.apar.poc.dao.AccountReceiveableDao;
import com.techminds.apar.poc.model.AccountReceoveable;
import com.techminds.apar.poc.service.AccountReceiveableService;

@Service
public class AccountReceiveableServiceImpl implements AccountReceiveableService{

	@Autowired
	private AccountReceiveableDao dao;
	
	@Override
	public List<AccountReceoveable> getAccountReceivable(String paramDate) {
		
		return dao.getAccountReceivable(paramDate);
	}

}

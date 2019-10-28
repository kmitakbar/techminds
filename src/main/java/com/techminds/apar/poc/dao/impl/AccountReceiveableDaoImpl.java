package com.techminds.apar.poc.dao.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techminds.apar.poc.dao.AccountReceiveableDao;
import com.techminds.apar.poc.model.AccountReceoveable;
import com.techminds.apar.poc.util.DateUtil;

@Repository
public class AccountReceiveableDaoImpl implements AccountReceiveableDao {

	private final String GET_RECEIVEABLE_LIST="SELECT * FROM account_receivable where date(sold_date)=?";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public List<AccountReceoveable> getAccountReceivable(String paramDate) {
		List<AccountReceoveable> listReceive=new ArrayList<AccountReceoveable>();
		List<Map<String, Object>> records=jdbcTemplate.queryForList(GET_RECEIVEABLE_LIST, paramDate);
		records.forEach(row->{
			AccountReceoveable ar=new AccountReceoveable();
			ar.setAccountNumber((String)row.get("account_number"));
			ar.setSellerId((String)row.get("seller_id"));
			ar.setAmount((double)row.get("amount"));
			ar.setSoldDate(DateUtil.getDate(row.get("sold_date")));
			listReceive.add(ar);
		});
		return listReceive;
	}
	
	

}

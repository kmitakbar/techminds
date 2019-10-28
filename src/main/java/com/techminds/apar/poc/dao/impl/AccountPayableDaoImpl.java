package com.techminds.apar.poc.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techminds.apar.poc.dao.AccountPayableDao;
import com.techminds.apar.poc.model.AccountPayable;
import com.techminds.apar.poc.util.DateUtil;

@Repository
public class AccountPayableDaoImpl implements AccountPayableDao {

	private final String GET_PAYABLE_LIST="SELECT * FROM account_payables where date(purchase_date)=?";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AccountPayable> getAccountPayable(String paramDate) {
		List<AccountPayable> listPayable=new ArrayList<AccountPayable>();
		List<Map<String, Object>> records=jdbcTemplate.queryForList(GET_PAYABLE_LIST, paramDate);
		System.out.println(paramDate+"records::::"+records);
		records.forEach(row->{
			AccountPayable ap=new AccountPayable();
			ap.setAccountNumber((String)row.get("account_number"));
			ap.setBuyerId((String)row.get("buyer_id"));
			ap.setAmount((double)row.get("amount"));
			ap.setPurchaseDate(DateUtil.getDateFrom(row.get("purchase_date")));
			listPayable.add(ap);
		});
		return listPayable;
	}
	
	

}

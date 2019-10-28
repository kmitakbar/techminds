package com.techminds.apar.poc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techminds.apar.poc.dao.AccountSummeryDao;
import com.techminds.apar.poc.model.AccountSummery;
import com.techminds.apar.poc.model.SummeryListSorting;

@Repository
public class AccountSummeryDaoImpl implements AccountSummeryDao {

	private final String GET_PAYABLE_AMOUNT_LIST = "SELECT sum(amount) as amount, date(purchase_date) as date FROM account_payables group by date(purchase_date)";
	private final String GET_RECEIVABLE_AMOUNT_LIST = "SELECT sum(amount) as amount, date(sold_date) as date FROM account_receivable group by date(sold_date)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AccountSummery> getSummery() {
		List<AccountSummery> listSummery=new LinkedList<AccountSummery>();
		List<Map<String, Object>> payableRecords=jdbcTemplate.queryForList(GET_PAYABLE_AMOUNT_LIST);
		List<Map<String, Object>> receivableRecords=jdbcTemplate.queryForList(GET_RECEIVABLE_AMOUNT_LIST);
		
		receivableRecords.forEach(pr->{
			AccountSummery as=new AccountSummery();
			Date date=(Date)pr.get("date");
			as.setDate(date.toString());
			as.setPayableAmt(new Double(0));
			as.setReceivableAmt((Double)pr.get("amount"));
			listSummery.add(as);
		});
		
		ListIterator<Map<String, Object>> i=payableRecords.listIterator();
		while(i.hasNext()) {
			Map<String, Object> map=i.next();
			Date date=(Date)map.get("date");
			listSummery.forEach(ls->{
				System.out.println(date+":::"+ls.getDate());
				//if(new SimpleDateFormat("yyyy-MM-dd").format(date).equals(new SimpleDateFormat("yyyy-MM-dd").format(ls.getDate()))) {
				if(date.toString().substring(1, 10).equals(ls.getDate().toString().substring(1, 10))) {
					ls.setPayableAmt((Double)map.get("amount"));
					i.remove();
				}
			});
		}
		
		payableRecords.forEach(rr->{
			AccountSummery as=new AccountSummery();
			Date date=(Date)rr.get("date");
			as.setDate(date.toString());
			as.setPayableAmt((Double)rr.get("amount"));
			as.setReceivableAmt(new Double(0));
			listSummery.add(as);
		});
		
		Collections.sort(listSummery, new SummeryListSorting());
		 return listSummery; 
	}
}

package com.techminds.apar.poc.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techminds.apar.poc.model.AccountPayable;
import com.techminds.apar.poc.model.AccountReceoveable;
import com.techminds.apar.poc.model.AccountSummery;
import com.techminds.apar.poc.service.AccountPayableService;
import com.techminds.apar.poc.service.AccountReceiveableService;
import com.techminds.apar.poc.service.AccountSummeryService;

@RestController
@RequestMapping("/accounts/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountSummary {
	
	@Autowired
	private AccountReceiveableService receiveService;
	
	@Autowired
	private AccountPayableService payableService;
	
	@Autowired
	private AccountSummeryService summeryService;

	@RequestMapping("/payables")
	public @ ResponseBody List<AccountPayable> getAccountPayables(@RequestParam("date") String date) {

		return payableService.getAccountPayable(date);
	}
	
	
	@RequestMapping("/receivables")
	public @ResponseBody List<AccountReceoveable> getAccountReceivable(@RequestParam("date") String date) {

		return receiveService.getAccountReceivable(date);
	}
	
	@RequestMapping("/summery")
	public @ResponseBody List<AccountSummery> getSummery(){
		
		return summeryService.getSummery();
	}
	
	@RequestMapping("/ping")
	public String testApi() {
		return "success!";
	}
	
	
}

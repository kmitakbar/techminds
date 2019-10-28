package com.techminds.apar.poc.model;

import java.util.Comparator;

public class SummeryListSorting implements Comparator<AccountSummery> {

	@Override
	public int compare(AccountSummery o1, AccountSummery o2) {
		
		return o1.getDate().compareTo(o2.getDate());
	}

}

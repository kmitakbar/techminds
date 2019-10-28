package com.techminds.apar.poc.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtil {

	public static String getDateFrom(Object object) {
		Timestamp timestamp=(Timestamp)object;
		LocalDateTime date=LocalDateTime
		        .ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
		return date.minusDays(1).toLocalDate().toString();
	}
	
	public static String getDate(Object object) {
		Timestamp timestamp=(Timestamp)object;
		LocalDateTime date=LocalDateTime
		        .ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));
		return date.toLocalDate().toString();
	}
}

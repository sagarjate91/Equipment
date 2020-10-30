package com.measuring.equipment.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
		DateFor = new SimpleDateFormat("ddMMyyyy");
		return DateFor.format(date);
	}
	
}

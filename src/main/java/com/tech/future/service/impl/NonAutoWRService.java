package com.tech.future.service.impl;

import java.util.Calendar;
import java.util.Date;

import com.tech.future.service.intf.INonAutoWRService;

/**
 * This is non-auto wired service class implementation example.
 * 
 * @author salil
 * @version 1.0.0
 */
public class NonAutoWRService implements INonAutoWRService {

	@Override
	public Date getDateTomorrow() {
		Date now = new Date();  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(now);  
		cal.add(Calendar.DAY_OF_YEAR, 1);  
		return cal.getTime();  	
	}
}

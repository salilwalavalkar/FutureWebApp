package com.tech.future.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.future.dao.intf.ICommonDao;
import com.tech.future.service.intf.IAutoWRService;

/**
 * This is an Autowired service class implementation example.
 * 
 * @author salil
 * @version 1.0.0
 */
@Service
public class AutoWRService implements IAutoWRService {

	@Autowired
	private ICommonDao commonDao;

	@Override
	public Date getDateToday() {
		return new Date();
	}
}

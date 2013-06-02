package com.tech.future.service.intf;

import java.util.Date;

import com.tech.future.service.base.IService;

/**
 * This is an Autowired service interface example.
 * 
 * @author salil
 * @version 1.0
 */
public interface IAutoWRService extends IService {

	Date getDateToday();
}

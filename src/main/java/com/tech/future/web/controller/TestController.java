package com.tech.future.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.tech.future.base.exception.BaseException;
import com.tech.future.service.intf.IAutoWRService;
import com.tech.future.service.intf.INonAutoWRService;

/**
 * #SPRING
 * @author salil
 */
@Controller
public class TestController extends AbstractController {

	/*************** Auto Wired Service - Start **********************************/
	@Autowired
	private IAutoWRService autoWRService;
	
	/*************** Auto Wired Service - End ************************************/

	/*************** Non Auto Wired Service - End ********************************/
	private INonAutoWRService nonAutoWRService;

	public INonAutoWRService getNonAutoWRService() {
		return nonAutoWRService;
	}

	public void setNonAutoWRService(INonAutoWRService nonAutoWRService) {
		this.nonAutoWRService = nonAutoWRService;
	}
	/*************** Non Auto Wired Service - End ********************************/
	
	/**
	 * Note: This method is incomplete as no view is returned. This is added 
	 * just added to show auto wired vs non auto wired classes.
	 */
	public ModelAndView getService() throws BaseException {

		Date today = autoWRService.getDateToday();
		Date tomorrow = nonAutoWRService.getDateTomorrow();
		
		System.out.println("Today: " + today);
		System.out.println("Tommorrow: " + tomorrow);
		return null;
	}
}
package com.acumedicalinc.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class DisplayDataController {

	@RequestMapping(value = "/displayData", method = RequestMethod.POST)
	public @ResponseBody String DisplayDataHandler(@RequestParam("numRows") String numRows){
		
		
		return "";
	}
	
}

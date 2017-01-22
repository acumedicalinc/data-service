package com.acumedicalinc.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Welcome to ACU Medical";

		@RequestMapping("/")
		public String index(Map<String, Object> model) {
			model.put("message", this.message);
			return "jsp/welcome.jsp";
		}
	
		@RequestMapping("/{website}")
	    public String website(Model model, @PathVariable String website) {
	        model.addAttribute("name", website);
	        
	        if (!StringUtils.isEmpty(website)) {
	        		return "jsp/" + website + ".jsp";
	        }
	        
	        return "jsp/error.jsp";
	    }
		
		@RequestMapping("/upload/{subject}")
	    public String subWebsite(Model model, @PathVariable String subject) {
			model.addAttribute("name", "/upload/" + subject);
			
	        if (!StringUtils.isEmpty(subject)) {
	        		return "jsp/upload/" + subject + ".jsp";
	        }
	        
			return "jsp/error.jsp";
	    }
}

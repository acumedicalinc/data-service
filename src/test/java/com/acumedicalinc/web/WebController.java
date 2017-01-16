package com.acumedicalinc.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	    public String hello(Model model, @PathVariable String website) {
	        model.addAttribute("name", website);
	        
	        if (website != null && website.length() > 0) {
	        		return "jsp/" + website + ".jsp";
	        }
	        
	        return "error.html";
	    }
}

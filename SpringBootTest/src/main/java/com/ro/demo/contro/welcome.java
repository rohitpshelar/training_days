package com.ro.demo.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class welcome {
	
	@RequestMapping(path = "/welcome")
	public String index() {
		System.out.println("index");
return "welcome";
	}

}

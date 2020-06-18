package com.ro.demo.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class welcome {
	
	@RequestMapping(path = "/welcome")
	//@ResponseBody
	public String index() {
		System.out.println("index4");
		return "index/index";
	}

}

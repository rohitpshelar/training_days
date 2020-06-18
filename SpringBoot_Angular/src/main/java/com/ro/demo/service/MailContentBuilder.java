package com.ro.demo.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailContentBuilder {
	
	private final TemplateEngine templateEngine;
	
	String build(String message) {
		Context context = new Context();
		context.setVariable("message", message);
		//mailTemplate is html file name
		return templateEngine.process("mailTemplate", context);
		
	}

}

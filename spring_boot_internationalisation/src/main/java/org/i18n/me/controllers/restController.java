package org.i18n.me.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class restController {
	
	private final MessageSource messageSource;
	
	
	
	public restController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}



	@RequestMapping("/standard")
	public String getMessage() {
		
		return messageSource.getMessage("common.hi", null,LocaleContextHolder.getLocale());
		
	}

	@RequestMapping("/header_attachement")
	public String getMessageWithHeader(@RequestHeader(name="Accept-Language",required = false) Locale local ) {
		
		
		return messageSource.getMessage("common.hi", null,LocaleContextHolder.getLocale());
	}
	
}

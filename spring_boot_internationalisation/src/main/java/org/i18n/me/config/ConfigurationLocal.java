package org.i18n.me.config;

import java.util.Locale;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ConfigurationLocal {

	@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver  sessionLocaleResolver=new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.FRENCH);
		return sessionLocaleResolver;
	}
}

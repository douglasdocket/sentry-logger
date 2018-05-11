package br.com.docket.sentry.configuration;

import io.sentry.spring.SentryExceptionResolver;
import io.sentry.spring.SentryServletContextInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerExceptionResolver;

@ComponentScan(basePackages = "br.com.docket.sentry.*")
public class SentryConfiguration {

	@Bean
	public ServletContextInitializer sentryServletContextInitializer() {
		return new SentryServletContextInitializer();
	}

	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
		return new SentryExceptionResolver();
	}

}

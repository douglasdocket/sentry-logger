package br.com.docket.sentry.logger;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;
import io.sentry.event.interfaces.ExceptionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SentryLogger {

	@Autowired
	private Environment environment;

	public void debug(String message, Class clazz) {
		EventBuilder eventBuilder = 
				new EventBuilder()
				.withMessage(message)
				.withEnvironment(this.environment.getActiveProfiles()[0])
				.withLevel(Event.Level.DEBUG)
				.withLogger(clazz.getName());

		Sentry.capture(eventBuilder);
	}

	public void info(String message, Class clazz) {
		EventBuilder eventBuilder = 
				new EventBuilder()
				.withMessage(message)
				.withEnvironment(this.environment.getActiveProfiles()[0])
				.withLevel(Event.Level.INFO)
				.withLogger(clazz.getName());

		Sentry.capture(eventBuilder);
	}
	
	public void warning(String message, Class clazz) {
		EventBuilder eventBuilder = 
				new EventBuilder()
				.withMessage(message)
				.withEnvironment(this.environment.getActiveProfiles()[0])
				.withLevel(Event.Level.WARNING)
				.withLogger(clazz.getName());

		Sentry.capture(eventBuilder);
	}

	public void error(Exception exception, Class clazz) {
		EventBuilder eventBuilder = 
				new EventBuilder()
				.withMessage(exception.getMessage())
				.withEnvironment(this.environment.getActiveProfiles()[0])
				.withLevel(Event.Level.ERROR)
				.withLogger(clazz.getName())
				.withSentryInterface(new ExceptionInterface(exception));

		Sentry.capture(eventBuilder);
	}

}
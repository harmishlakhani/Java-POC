package com.github.harmishlakhani.application;

import com.github.harmishlakhani.di.consumer.MessageConsumer;
import com.github.harmishlakhani.di.injector.MessageServiceInjector;
import com.github.harmishlakhani.di.injector.impl.EmailServiceInjector;
import com.github.harmishlakhani.di.injector.impl.SMSServiceInjector;

public class MessageApplication {

	public static void main(String[] args) {
		
		String message = "Hi HArmish";
		String receiverEmail = "harmish.lakhani@gmail.com";
		String receiverPhone = "9880633084";
		
		MessageServiceInjector injector;
		MessageConsumer app;
		
		//Email
		injector = new EmailServiceInjector();
		app = injector.getMessageConsumer();
		app.processMessage(message, receiverEmail);
		
		//SMS
		injector = new SMSServiceInjector();
		app = injector.getMessageConsumer();
		app.processMessage(message, receiverPhone);
	}
}

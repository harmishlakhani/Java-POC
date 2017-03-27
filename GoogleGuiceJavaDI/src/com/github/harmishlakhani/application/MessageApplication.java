package com.github.harmishlakhani.application;

import com.github.harmishlakhani.di.consumer.ConsumerDIApplication;
import com.google.inject.Guice;
import com.google.inject.Injector;

import injector.MessageAppInjector;

public class MessageApplication {

	public static void main(String[] args) {
		
		String message = "Hi HArmish";
		String receiverEmail = "harmish.lakhani@gmail.com";
		String receiverPhone = "9880633084";
		
		Injector injector = Guice.createInjector(new MessageAppInjector());
		
		ConsumerDIApplication consumerDIApplication = injector.getInstance(ConsumerDIApplication.class);
		consumerDIApplication.processMessage(message, receiverEmail);
	}
}

package com.github.harmishlakhani.di.injector.impl;

import com.github.harmishlakhani.di.consumer.MessageConsumer;
import com.github.harmishlakhani.di.consumer.impl.ConsumerDIApplication;
import com.github.harmishlakhani.di.injector.MessageServiceInjector;
import com.github.harmishlakhani.di.service.impl.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public MessageConsumer getMessageConsumer() {
		return new ConsumerDIApplication(new SMSServiceImpl());
	}
}

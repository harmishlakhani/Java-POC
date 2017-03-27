package com.github.harmishlakhani.di.consumer.impl;

import com.github.harmishlakhani.di.consumer.MessageConsumer;
import com.github.harmishlakhani.di.service.MessageService;

public class ConsumerDIApplication implements MessageConsumer {

	private MessageService messageService;
	
	public ConsumerDIApplication(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@Override
	public void processMessage(String message, String receiver) {
		//processing message before sending
		this.messageService.sendMessage(message, receiver);
	}
}

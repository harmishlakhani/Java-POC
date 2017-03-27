package com.github.harmishlakhani.di.consumer;

import com.github.harmishlakhani.di.service.MessageService;
import com.google.inject.Inject;

public class ConsumerDIApplication {

	private MessageService messageService;
	
	//constructor injection
	@Inject
	public ConsumerDIApplication(MessageService messageService) {
		this.messageService = messageService;
	}
	
	//setter injection
	@Inject
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void processMessage(String message, String receiver) {
		//processing message before sending
		this.messageService.sendMessage(message, receiver);
	}
}

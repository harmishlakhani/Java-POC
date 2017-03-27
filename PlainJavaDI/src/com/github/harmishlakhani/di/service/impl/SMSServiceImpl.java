package com.github.harmishlakhani.di.service.impl;

import com.github.harmishlakhani.di.service.MessageService;

public class SMSServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		//Sending Email
		System.out.println("SMS sent to " + receiver + " with message : " + message);
	}

}

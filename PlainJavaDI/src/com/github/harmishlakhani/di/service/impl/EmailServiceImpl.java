package com.github.harmishlakhani.di.service.impl;

import com.github.harmishlakhani.di.service.MessageService;

public class EmailServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		//Sending Email
		System.out.println("Email sent to " + receiver + " with message : " + message);
	}

}

package com.github.harmishlakhani.di.service.impl;

import javax.inject.Singleton;

import com.github.harmishlakhani.di.service.MessageService;

@Singleton
public class EmailServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		//Sending Email
		System.out.println("Email sent to " + receiver + " with message : " + message);
	}

}

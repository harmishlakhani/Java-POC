package com.github.harmishlakhani.di.service.impl;

import com.github.harmishlakhani.di.service.MessageService;

public class FacebookServiceImpl implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		//Sending Facebook message
		System.out.println("Facebook message sent to " + receiver + " with message : " + message);
	}

}

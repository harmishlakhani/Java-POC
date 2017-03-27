package com.github.harmishlakhani.legacy;

public class EmailService {

	public void sendEmail(String message, String emailId) {
		//Sending Email
		System.out.println("Email sent to " + emailId + " with message : " + message);
	}
}

package com.github.harmishlakhani.legacy;

public class EmailApplication {

	private EmailService emailService = new EmailService();
	
	public void processMessage(String message, String emailId) {
		emailService.sendEmail(message, emailId);
	}
}

package com.github.harmishlakhani.legacy;

public class ServiceClient {

	public static void main(String[] args) {
		EmailApplication app = new EmailApplication();
		app.processMessage("Hi Harmish", "harmish.lakhani@gmail.com");
	}
}

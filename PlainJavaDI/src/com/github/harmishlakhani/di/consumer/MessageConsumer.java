package com.github.harmishlakhani.di.consumer;

public interface MessageConsumer {

	public void processMessage(String message, String receiver);
}

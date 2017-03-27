package com.github.harmishlakhani.di.injector;

import com.github.harmishlakhani.di.consumer.MessageConsumer;

public interface MessageServiceInjector {

	public MessageConsumer getMessageConsumer();
}

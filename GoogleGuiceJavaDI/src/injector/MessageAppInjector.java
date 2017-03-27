package injector;

import com.github.harmishlakhani.di.service.MessageService;
import com.github.harmishlakhani.di.service.impl.EmailServiceImpl;
import com.github.harmishlakhani.di.service.impl.FacebookServiceImpl;
import com.github.harmishlakhani.di.service.impl.SMSServiceImpl;
import com.google.inject.AbstractModule;

public class MessageAppInjector extends AbstractModule {

	@Override
	protected void configure() {
		//bind(MessageService.class).to(EmailServiceImpl.class);
		//bind(MessageService.class).to(FacebookServiceImpl.class);
		bind(MessageService.class).to(SMSServiceImpl.class);
	}

}

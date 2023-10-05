package com.lambda.primary.EventListeners;

import com.lambda.primary.Events.RegistrationEvent;
import org.springframework.context.ApplicationListener;

public class RegistrationEventListener implements ApplicationListener<RegistrationEvent> {
    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        //custom api call
    }
}

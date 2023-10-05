package com.lambda.primary.EventPublishers;

import com.lambda.primary.Events.RegistrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class RegistrationEventPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publishEvent(RegistrationEvent event){
        eventPublisher.publishEvent(event);
    }

}

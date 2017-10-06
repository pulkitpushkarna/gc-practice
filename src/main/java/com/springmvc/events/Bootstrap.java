package com.springmvc.events;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap {

    @EventListener(ContextRefreshedEvent.class)
    void startUpEvent(){

    }

}

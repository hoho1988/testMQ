package com.hoho.testspringboot.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer222222222222=====================" +text);
    }
}

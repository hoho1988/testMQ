package com.hoho.testspringboot.service;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
@Component
public class TestProducer {
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private Queue queue =new ActiveMQQueue("sample.queue");
    
    public void send(String msg) {
    	if(("a").equals(msg)){
    		this.jmsMessagingTemplate.convertAndSend(queue, "myname is hahahahahah!!!");
    	}else{
    		System.out.println("param is wrong!!!!!!!");
    	}
        
    }
}

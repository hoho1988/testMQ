package com.hoho.testspringboot.controller;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoho.testspringboot.service.TestProducer;

@RestController
public class ProducerController {
	@Autowired
	TestProducer producer;
	
    @RequestMapping("/sendMsg")
    public void send(String msg) {
    	for(int i=0; i<10; i++){  
            producer.send(msg);  
        } 
    }
}

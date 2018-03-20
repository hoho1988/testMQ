package com.hoho.testspringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoho.testspringboot.ClassBean;
import com.hoho.testspringboot.service.TestWSqq;
import com.hoho.testspringboot.service.TestWStaobao;

@ConfigurationProperties
@RestController
public class TestController {

	@Autowired
	TestWSqq testWSqq;
	@Autowired
	TestWStaobao testWStaobao;
	
	
	@RequestMapping("/test")
	public Object hello(@Valid @RequestBody ClassBean c,BindingResult result){
		List<FieldError> list = result.getFieldErrors();
		if(list.size()>0){
			for (FieldError f : list) {
				System.out.println(f.getField());
				System.out.println(f.getDefaultMessage());
				
			}
			return "valid!!";
		}else{
			return "no valid!!";
		}
	}
	@RequestMapping("/getResult")
	public String getResult(String tel) throws Exception{
		
		
		
		return testWStaobao.getResult(tel);
	}
	@RequestMapping("/getResultqq")
	public String getResultqq(@RequestBody String xml) throws Exception{
		
		
		
		return testWSqq.getResult(xml);
	}
	
	
	@RequestMapping("/a")
	public String test(){
		
		
		
		return "asdff";
	}
	
}

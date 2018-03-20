package com.hoho.testspringboot;

import javax.validation.Valid;


public class ClassBean {
	@Valid
	private StuBean stu;

	public StuBean getStu() {
		return stu;
	}

	public void setStu(StuBean stu) {
		this.stu = stu;
	}
	
	
}

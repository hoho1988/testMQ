package com.hoho.testspringboot;

import org.hibernate.validator.constraints.NotEmpty;

public class StuInfoBean {
	@NotEmpty(message="真是姓名不能为空")
	private String realName;
	@NotEmpty(message="年龄不能为空")
	private String age;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}

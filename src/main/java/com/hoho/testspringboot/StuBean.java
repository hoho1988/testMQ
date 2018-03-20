package com.hoho.testspringboot;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class StuBean {
	@NotEmpty(message="名字不能为空")
	@Pattern(regexp="^[a-zA-Z]+$",message="regexp not pass")
	private String name;
	@NotEmpty(message="密码不能为空")
	private String pwd;
	@Valid
	private StuInfoBean info;
	public StuInfoBean getInfo() {
		return info;
	}
	public void setInfo(StuInfoBean info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

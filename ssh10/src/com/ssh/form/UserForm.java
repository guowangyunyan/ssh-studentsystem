package com.ssh.form;

public class UserForm {
	private Integer id;
	private String name;// 用户名
	private String mobile;
	private String password;// 密码
	private String confirmPassword;// 确认密码
	private boolean isNew;
	private String pothoPath;
	private boolean rememberMe;// 记住密码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getPothoPath() {
		return pothoPath;
	}

	public void setPothoPath(String pothoPath) {
		this.pothoPath = pothoPath;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

}

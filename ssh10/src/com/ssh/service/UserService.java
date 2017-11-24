package com.ssh.service;

import java.util.List;

import com.ssh.data.UserData;
import com.ssh.form.UserForm;

public interface UserService {

	UserData queryUser(UserForm userForm);

	List<UserData> uniqueByName(String name);

	void save(UserForm userForm);

}

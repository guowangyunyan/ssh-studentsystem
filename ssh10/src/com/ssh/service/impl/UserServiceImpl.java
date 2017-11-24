package com.ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.ssh.common.service.CommonService;
import com.ssh.convert.UserConvert;
import com.ssh.dao.UserDao;
import com.ssh.data.UserData;
import com.ssh.form.UserForm;
import com.ssh.model.UserModel;
import com.ssh.service.UserService;

public class UserServiceImpl implements UserService {
	private CommonService commonService;
	private Md5PasswordEncoder md5Encoder;
	private UserDao userDao;
	private UserConvert userConvert;

	@Override
	public UserData queryUser(UserForm userForm) {
		UserData userData = new UserData();
		Map<String, Object> fields = new HashMap<>();
		fields.put(UserModel.NAME, userForm.getName());
		String password = md5Encoder.encodePassword(userForm.getPassword(), userForm.getName());
		fields.put(UserModel.PASSWORD, password);
		List<UserModel> list = commonService.getEntitiesByFields(UserModel.class, fields);
		// if (list != null && list.size() > 0) {
		if (CollectionUtils.isNotEmpty(list)) {
			UserModel userModel = list.get(0);
			userData = userConvert.convert(userModel);
		}
		return userData;
	}

	@Override
	public List<UserData> uniqueByName(String name) {

		return null;
	}

	@Override
	public void save(UserForm userForm) {

	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Md5PasswordEncoder getMd5Encoder() {
		return md5Encoder;
	}

	public void setMd5Encoder(Md5PasswordEncoder md5Encoder) {
		this.md5Encoder = md5Encoder;
	}

	public UserConvert getUserConvert() {
		return userConvert;
	}

	public void setUserConvert(UserConvert userConvert) {
		this.userConvert = userConvert;
	}

}

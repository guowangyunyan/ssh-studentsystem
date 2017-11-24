package com.ssh.convert;

import com.ssh.data.UserData;
import com.ssh.model.UserModel;

public class UserConvert implements Convert<UserModel, UserData> {

	@Override
	public UserData createTarget() {
		return new UserData();
	}

	@Override
	public UserData convert(UserModel model) {
		UserData data = createTarget();
		data.setId(model.getId());
		data.setName(model.getName());
		data.setMobile(model.getMobile());
		data.setPhoto(model.getPhoto());
		data.setCreateDate(model.getCreateDate());
		data.setUpdateDate(model.getUpdateDate());
		return data;
	}

}

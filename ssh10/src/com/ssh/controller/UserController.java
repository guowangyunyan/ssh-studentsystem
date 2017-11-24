package com.ssh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssh.data.UserData;
import com.ssh.form.UserForm;
import com.ssh.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Controller
public class UserController {
	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private UserService userService;

	@Resource
	private Validator validator;

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("userForm", new UserForm());
		logger.info("register page ...");
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserForm userForm, BindingResult bindingResult,
			@RequestParam("photo") MultipartFile photoFile, Model model) throws IOException {
		logger.info(String.format("register user [%s]...", ReflectionToStringBuilder.toString(userForm)));

		validator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.info("user error log: %s" + ReflectionToStringBuilder.toString(bindingResult));
			model.addAttribute("userForm", userForm);
			return "register";
		}

		// upload photo
		String fileName = photoFile.getOriginalFilename();

		String newFileName = System.currentTimeMillis() + "_" + fileName;

		String encodingName = Base64.encodeBase64String(newFileName.getBytes());
		String result = encodingName.replaceAll("/", "_");
		byte[] bytes = photoFile.getBytes();
		String basePath = "E:\\tianwei\\imageTest\\upload";
		String path = basePath + File.separator + newFileName;
		File photo = new File(path);
		OutputStream output = new FileOutputStream(photo);
		output.write(bytes);
		output.flush();
		output.close();

		userForm.setPothoPath(result);

		userService.save(userForm);

		return "redirect:login";
	}

	@RequestMapping(value = "/unique", method = RequestMethod.POST)
	@ResponseBody
	public Boolean unique(@RequestParam("name") String name) {
		List<UserData> list = userService.uniqueByName(name);
		Boolean flag = true;
		if (CollectionUtils.isNotEmpty(list)) {
			flag = false;
		}
		return flag;
	}
}

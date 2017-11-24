package com.ssh.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssh.data.UserData;
import com.ssh.form.UserForm;
import com.ssh.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private UserService userService;

	@Resource
	private Validator validator;

	@RequestMapping(name = "/login")
	public String login(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserForm userForm, BindingResult bindingResult, HttpSession session,
			HttpServletResponse response, Model model) {
		logger.info(String.format("login [%s]...", ReflectionToStringBuilder.toString(userForm)));
		validator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.info(String.format("user error log: %s", ReflectionToStringBuilder.toString(bindingResult)));
			model.addAttribute("userForm", userForm);
			return "login";
		}

		UserData userData = userService.queryUser(userForm);

		if (null == userData) {
			return "login";
		}
		session.setAttribute("userInfo", userData);
		if (userForm.isRememberMe()) {
			Cookie cookie = new Cookie("rememberMe", userForm.getName() + "($)" + userForm.getPassword());
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		}
		return "main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("userForm", new UserForm());
		session.invalidate();
		return "login";
	}
}

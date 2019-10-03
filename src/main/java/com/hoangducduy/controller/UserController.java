package com.hoangducduy.controller;

import com.hoangducduy.dao.UserDao;
import com.hoangducduy.model.Login;
import com.hoangducduy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("login") Login login) {
		User user = UserDao.CheckLogin(login);
		if (user == null) {
			ModelAndView modelAndView = new ModelAndView("error");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("user");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
	}
}
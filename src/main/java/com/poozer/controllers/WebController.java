package com.poozer.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.poozer.entities.ErrorMessage;
import com.poozer.entities.Message;
import com.poozer.entities.NotificationMessage;
import com.poozer.entities.User;
import com.poozer.repositories.UserRepository;

@Controller
public class WebController {
	private UserRepository userRepository;

	@Autowired
	public WebController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute User user) {
		Message message = null;
		ModelAndView modelAndView = new ModelAndView("index");
		User dbUser = userRepository.findByEmail(user.getEmail());
		if (dbUser == null) {
			userRepository.save(user);
			message = new NotificationMessage("Eita Da! Now that we've got your details, we'll stay in touch.");
		} else {
			message = new ErrorMessage("Oops! Seems like we already have those details, but thanks for the love.");
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	} 

	@RequestMapping("/send")
	public String send() {
		return "send";
	}

	@RequestMapping("/pickup")
	public String pickup() {
		return "pickup";
	}

}

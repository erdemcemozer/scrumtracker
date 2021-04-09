package com.example.scrumtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author erdemcemozer
 */

@Controller
public class MainWebController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "signinpage"; // will look later
	}
}

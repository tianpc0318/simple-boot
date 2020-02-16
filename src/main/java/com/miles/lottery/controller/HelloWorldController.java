package com.miles.lottery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping("/world")
	String home() {
		logger.debug("Hello World...");
		return "Hello World...";
	}

	@RequestMapping("/{uname}")
	String index(@PathVariable String uname) {
		logger.debug("Hello，{}", uname);
		return "Hello， " + uname + "...";
	}

}
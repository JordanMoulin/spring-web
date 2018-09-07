package com.formation.controller;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/healthcheck")
public class HelloController {

	@GetMapping("/status")
	@ResponseBody
	public String getStatus() {
		return "Ok !";
	}

	@GetMapping("/variable/{name}")
	@ResponseBody
	public String getHelloVariable(@PathVariable String name) {
		return MessageFormat.format("Hi {0} !", name);
	}
}

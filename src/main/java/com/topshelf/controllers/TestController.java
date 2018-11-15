package com.topshelf.controllers;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class TestController {
	@ResponseBody
	@GetMapping(produces=MediaType.TEXT_PLAIN_VALUE)
	public String test() {
		return "Hello, Spring MVC!";
	}
}







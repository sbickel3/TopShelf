<<<<<<< HEAD
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
	@GetMapping(value="/fun",produces=MediaType.TEXT_PLAIN_VALUE)
	public String test() {
		return "Our ec2 is working!";
	}
}






=======
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
	@GetMapping(value="/fun",produces=MediaType.TEXT_PLAIN_VALUE)
	public String test() {
		return "Our ec2 is working!";
	}
}






>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa

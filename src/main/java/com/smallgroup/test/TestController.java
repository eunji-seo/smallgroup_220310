package com.smallgroup.test;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/test/{name}/{age}")
	public String test(@PathVariable("name") String name, @PathVariable("age") int age) {
		log.info("name=>{}", name);
		return "1";
	}
}

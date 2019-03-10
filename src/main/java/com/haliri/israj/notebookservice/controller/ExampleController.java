package com.haliri.israj.notebookservice.controller;

import com.haliri.israj.notebookservice.domain.User;
import com.haliri.israj.notebookservice.service.UserService;
import com.haliri.israj.notebookservice.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/adm")
public class ExampleController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/example_get", method = RequestMethod.GET)
	public Map exGet() {
		Map outP =  new HashMap();
		outP.put("outParam : ","this is example");
		return outP;
	}

	@RequestMapping(value = "/example_post", method = RequestMethod.POST)
	public void exPost(@RequestBody User user) {
		AppUtils.getLogger(this).info("EX PARAM : {}",user);
	}
}

package com.haliri.israj.controller;

import com.haliri.israj.domain.User;
import com.haliri.israj.service.UserService;
import com.haliri.israj.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/adm")
public class ExampleController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public Map exGet() {
		Map out = new HashMap();
		out.put("outParam : ", "this is example");

		return out;
	}
}

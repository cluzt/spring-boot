package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.TeamDao;
import com.example.domain.Team;

@Controller
public class HelloController {

	@Autowired
	TeamDao teamDao;

	@RequestMapping("/team/{name}")
	public @ResponseBody Team team(@PathVariable String name) {
		return teamDao.findByName(name);
	}

	@RequestMapping("/hello/{name}")
	public @ResponseBody String hello(@PathVariable String name) {
		return "Hi, " + name;
	}

}

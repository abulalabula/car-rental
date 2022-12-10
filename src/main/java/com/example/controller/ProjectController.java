package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

	 @RequestMapping("/add")
	 public String  add()
	 {
		 return "project_add" ;
	 }
}

package com.huylam98it.spboot.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String homePage() {
		File file = new File("C:/images");
		try {
			if (file.exists() == false)
				file.mkdirs();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "home";
	}

}

package com.huylam98it.spboot.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String homePage(@RequestParam(required = false) String link, Model model) {
		if (link != null) {
			model.addAttribute("link", link);
		}
		File file = new File("C:/images");
		try {
			if (file.exists() == false)
				file.mkdirs();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "home";
	}

}

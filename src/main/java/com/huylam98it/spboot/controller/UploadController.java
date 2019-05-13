package com.huylam98it.spboot.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@PostMapping(value = "/upload")
	public String upload(@RequestParam("mf") MultipartFile file) {
		try {
			File folderUpload = new File("C:/images");
			if (folderUpload.exists() == false) {
				folderUpload.mkdirs();
			}

			File oldFile = new File(folderUpload.getAbsolutePath(), file.getOriginalFilename());
			file.transferTo(oldFile);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return "redirect:/?link=" + file.getOriginalFilename();
	}

}

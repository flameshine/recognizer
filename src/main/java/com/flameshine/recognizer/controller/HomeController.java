package com.flameshine.recognizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import com.flameshine.recognizer.service.FileService;
import com.flameshine.recognizer.util.Constants;

/**
 * Home controller.
 */

@Controller
@RequestMapping({ "/", Constants.HOME_PATH })
public class HomeController {

    private final FileService service;

    @Autowired
    public HomeController(FileService service) {
        this.service = service;
    }

    @GetMapping
    public String home() {
        return Constants.HOME_PATH;
    }

    @PostMapping
    public ModelAndView home(@RequestParam("file") MultipartFile file) {

        service.handle(file);
        
        return new ModelAndView(Constants.HOME_PATH)
            .addObject("message", String.format("File '%s' has been uploaded successfully", file.getName()));
    }
}
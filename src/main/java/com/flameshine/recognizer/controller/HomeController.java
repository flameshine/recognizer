package com.flameshine.recognizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.TesseractException;

import com.flameshine.recognizer.service.RecognitionService;
import com.flameshine.recognizer.util.Constants;

/**
 * Home controller.
 */

@Controller
@RequestMapping({ "/", Constants.HOME_PATH })
public class HomeController {

    private final RecognitionService service;

    @Autowired
    public HomeController(RecognitionService service) {
        this.service = service;
    }

    @GetMapping
    public String home() {
        return Constants.HOME_PATH;
    }

    @PostMapping
    public ModelAndView home(@RequestParam("file") MultipartFile file) throws TesseractException {
        return new ModelAndView("/result")
            .addObject("result", service.recognize(file));
    }
}
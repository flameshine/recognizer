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

import com.flameshine.recognizer.service.Recognizer;
import com.flameshine.recognizer.service.Converter;
import com.flameshine.recognizer.util.Constants;

/**
 * Home controller.
 */

@Controller
@RequestMapping({ "/", Constants.HOME_PATH })
public class HomeController {

    private final Recognizer recognizer;
    private final Converter converter;

    @Autowired
    public HomeController(Recognizer recognizer, Converter converter) {
        this.recognizer = recognizer;
        this.converter = converter;
    }

    @GetMapping
    public String home() {
        return Constants.HOME_PATH;
    }

    @PostMapping
    public ModelAndView home(@RequestParam("file") MultipartFile file) throws TesseractException {

        if (file == null || file.isEmpty()) {
            return new ModelAndView(Constants.HOME_PATH)
                .addObject("message", "Invalid input");
        }

        var text = recognizer.recognize(
            converter.convert(file)
        );

        return new ModelAndView("/result")
            .addObject("text", text);
    }
}
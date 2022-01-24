package com.flameshine.recognizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    private final String datapath;

    @Autowired
    public Application(@Value("${tesseract.datapath}") String datapath) {
        this.datapath = datapath;
    }

    // TODO: dockerize the application

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ITesseract tesseract() {
        var tesseract = new Tesseract();
        tesseract.setDatapath(datapath);
        return tesseract;
    }
}
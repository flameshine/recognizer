package com.flameshine.recognizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import net.sourceforge.tess4j.Tesseract;

/**
 * Main class that launches the application.
 */

@SpringBootApplication
public class Application {

    // TODO: add 'file is not present' case handling
    // TODO: cover the logic with corresponding unit-tests
    // TODO: come up with idea how to re-locate the .dylib file
    // TODO: add various graphic file formats support
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Tesseract tesseract() {
        var tesseract = new Tesseract();
        tesseract.setDatapath("/usr/local/Cellar/tesseract/5.0.0/share/tessdata/");
        return tesseract;
    }
}
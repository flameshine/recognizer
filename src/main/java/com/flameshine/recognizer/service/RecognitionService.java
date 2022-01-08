package com.flameshine.recognizer.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.TesseractException;

/**
 * Service that recognizes text in a graphic file.
 */

// TODO: consider reworking the system to use this as a functional interface.
public interface RecognitionService {
    String recognize(MultipartFile file) throws TesseractException, IOException;
}
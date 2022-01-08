package com.flameshine.recognizer.service;

import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.TesseractException;

/**
 * Service that recognizes text in a graphic file.
 */

public interface RecognitionService {
    String recognize(MultipartFile file) throws TesseractException;
}
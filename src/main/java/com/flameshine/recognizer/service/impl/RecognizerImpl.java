package com.flameshine.recognizer.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import lombok.extern.slf4j.Slf4j;

import com.flameshine.recognizer.service.Recognizer;

/**
 * Implementation of {@link com.flameshine.recognizer.service.Recognizer}.
 */

@Service
@Slf4j
public class RecognizerImpl implements Recognizer {

    private final ITesseract tesseract;

    @Autowired
    public RecognizerImpl(ITesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String recognize(File file) throws TesseractException {

        log.info("Processing file: {}", file.getAbsolutePath());

        return tesseract.doOCR(file);
    }
}
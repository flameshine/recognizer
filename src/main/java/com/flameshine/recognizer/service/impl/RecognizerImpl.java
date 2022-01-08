package com.flameshine.recognizer.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import com.flameshine.recognizer.service.Recognizer;

/**
 * Implementation of {@link Recognizer}.
 */

@Service
public class RecognizerImpl implements Recognizer {

    private final Tesseract tesseract;

    @Autowired
    public RecognizerImpl(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String recognize(File file) throws TesseractException {
        return tesseract.doOCR(file);
    }
}
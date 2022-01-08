package com.flameshine.recognizer.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import com.flameshine.recognizer.service.RecognitionService;

/**
 * Implementation of {@link com.flameshine.recognizer.service.RecognitionService}.
 */

@Service
public class RecognitionServiceImpl implements RecognitionService {

    private final Tesseract tesseract;

    @Autowired
    public RecognitionServiceImpl(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String recognize(MultipartFile file) throws TesseractException, IOException {

        // TODO: add file type customization + consider ways to prettify this
        var temporaryFile = File.createTempFile("temp", ".png");

        temporaryFile.deleteOnExit();
        file.transferTo(temporaryFile);

        return tesseract.doOCR(temporaryFile);
    }
}
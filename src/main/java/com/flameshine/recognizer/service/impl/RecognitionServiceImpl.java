package com.flameshine.recognizer.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import com.flameshine.recognizer.service.RecognitionService;
import com.flameshine.recognizer.util.FileConverter;

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
    public String recognize(MultipartFile multipartFile) throws TesseractException {
        return tesseract.doOCR(
            FileConverter.convert(multipartFile)
        );
    }
}
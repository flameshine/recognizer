package com.flameshine.recognizer.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flameshine.recognizer.service.Converter;

/**
 * Implementation of {@link Converter}.
 */

@Service
public class ConverterImpl implements Converter {

    @Override
    public File convert(MultipartFile multipartFile) {

        try {

            var file = File.createTempFile("temporary", ".png");

            file.deleteOnExit();
            multipartFile.transferTo(file);

            return file;

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
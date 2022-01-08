package com.flameshine.recognizer.util;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * Auxiliary utility that converts {@link MultipartFile} to {@link File}.
 */

public final class FileConverter {

    private FileConverter() {}

    // TODO: consider ways prettifying this
    public static File convert(MultipartFile multipartFile) {

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
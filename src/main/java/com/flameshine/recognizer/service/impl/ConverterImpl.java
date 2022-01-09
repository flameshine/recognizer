package com.flameshine.recognizer.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import lombok.extern.slf4j.Slf4j;

import com.flameshine.recognizer.service.Converter;

/**
 * Implementation of {@link Converter}.
 */

@Service
@Slf4j
public class ConverterImpl implements Converter {

    @Override
    public File convert(MultipartFile multipartFile) {

        try {

            var extension = FilenameUtils.getExtension(
                multipartFile.getOriginalFilename()
            );

            var file = File.createTempFile("temporary", "." + extension);

            log.info("Created a temporary file: {}", file.getAbsolutePath());

            file.deleteOnExit();
            multipartFile.transferTo(file);

            return file;

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
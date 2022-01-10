package com.flameshine.recognizer.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * Service that converts {@link org.springframework.web.multipart.MultipartFile} to {@link java.io.File}.
 */

public interface Converter {
    File convert(MultipartFile multipartFile) throws IOException;
}
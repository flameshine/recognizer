package com.flameshine.recognizer.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * Service that converts {@link MultipartFile} to {@link File}.
 */

public interface Converter {
    File convert(MultipartFile multipartFile);
}
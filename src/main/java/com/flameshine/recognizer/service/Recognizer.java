package com.flameshine.recognizer.service;

import java.io.File;

import net.sourceforge.tess4j.TesseractException;

/**
 * Service that recognizes text in a graphic file.
 */

public interface Recognizer {
    String recognize(File file) throws TesseractException;
}
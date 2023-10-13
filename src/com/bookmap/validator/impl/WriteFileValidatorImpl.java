package com.bookmap.validator.impl;

import com.bookmap.util.FileValidatorUtil;
import com.bookmap.util.IOUtil;
import com.bookmap.validator.Validator;

import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFileValidatorImpl implements Validator<String> {
    @Override
    public void isValid(String outputPathToFile) {
        FileValidatorUtil.isValidPathToFile(outputPathToFile);

        if (!Files.exists(Paths.get(outputPathToFile))) {
            IOUtil.createFile(outputPathToFile);
        }
    }
}
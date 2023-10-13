package com.bookmap.validator.impl;

import com.bookmap.util.FileValidatorUtil;
import com.bookmap.validator.Validator;

public class ReadFileValidatorImpl implements Validator<String> {
    @Override
    public void isValid(String inputPathToFile) {
        FileValidatorUtil.isValidPathToFile(inputPathToFile);

        FileValidatorUtil.isFileExist(inputPathToFile);

        FileValidatorUtil.isEmptyFile(inputPathToFile);
    }
}
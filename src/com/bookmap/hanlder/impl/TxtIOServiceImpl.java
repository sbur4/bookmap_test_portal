package com.bookmap.hanlder.impl;

import com.bookmap.dto.OutputDto;
import com.bookmap.hanlder.IOService;
import com.bookmap.util.IOUtil;
import com.bookmap.validator.Validator;

import java.util.List;

public class TxtIOServiceImpl implements IOService<List<String>, OutputDto, String> {
    @Override
    public List<String> readData(String inputPathToFile, Validator validator) {
        validator.isValid(inputPathToFile);

        return IOUtil.readDataFromFile(inputPathToFile);
    }

    @Override
    public void writeData(OutputDto outputDto, String outputPathToFile, Validator validator) {
        validator.isValid(outputPathToFile);

        IOUtil.writeDataToFile(outputPathToFile, outputDto.getResult());
    }
}
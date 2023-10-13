package com.bookmap.hanlder;

import com.bookmap.validator.Validator;

public interface IOService<C, O, S> {
    C readData(S inputPathToFile, Validator validator);

    void writeData(O outputDto, S outputPathToFile, Validator validator);
}
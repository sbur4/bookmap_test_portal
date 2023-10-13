package com.bookmap.factory;

import com.bookmap.validator.impl.InputDataValidatorImpl;
import com.bookmap.validator.impl.ReadFileValidatorImpl;
import com.bookmap.validator.impl.WriteFileValidatorImpl;

public class ValidatorFactory {
    private final ReadFileValidatorImpl readFileValidator;
    private final InputDataValidatorImpl inputDataValidator;
    private final WriteFileValidatorImpl writeFileValidator;

    public ValidatorFactory(ReadFileValidatorImpl readFileValidator, InputDataValidatorImpl inputDataValidator,
                            WriteFileValidatorImpl writeFileValidator) {
        this.readFileValidator = readFileValidator;
        this.inputDataValidator = inputDataValidator;
        this.writeFileValidator = writeFileValidator;
    }

    public ReadFileValidatorImpl createReadFileValidator() {
        return readFileValidator;
    }

    public InputDataValidatorImpl createInputDataValidator() {
        return inputDataValidator;
    }

    public WriteFileValidatorImpl createWriteFileValidator() {
        return writeFileValidator;
    }
}
package com.bookmap.validator.impl;

import com.bookmap.model.Datas;
import com.bookmap.validator.Validator;

import java.util.LinkedList;
import java.util.List;

public class InputDataValidatorImpl implements Validator<Datas> {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100_000;

    @Override
    public void isValid(Datas datas) {
        List<String> errorMessages = new LinkedList<>();

        validateNumber(datas.getQIsNumberOfQueries(), "q", errorMessages);
        validateNumber(datas.getNIsLengthOfS(), "n", errorMessages);

        validateSLength(datas, errorMessages);

        datas.getQueryList().forEach(query -> {
            validateNumber(query.getL(), "l", errorMessages);
            validateNumber(query.getR(), "r", errorMessages);
            validateNumber(query.getK(), "k", errorMessages);

            if (query.getL() > query.getR() || query.getK() > query.getR() - query.getL() + 1) {
                errorMessages.add(String.format("Invalid query: l=%d, r=%d, k=%d", query.getL(), query.getR(),
                        query.getK()));
            }
        });

        validateQueriesSize(datas, errorMessages);

        if (!errorMessages.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errorMessages));
        }
    }

    private static void validateQueriesSize(Datas datas, List<String> errorMessages) {
        if (datas.getQueryList().size() != datas.getQIsNumberOfQueries()) {
            errorMessages.add(String.format("Invalid size of the  queries {%s}: %d", datas.getQueryList(),
                    datas.getQIsNumberOfQueries()));
        }
    }

    private static void validateSLength(Datas datas, List<String> errorMessages) {
        if (datas.getStringS().length() != datas.getNIsLengthOfS()) {
            errorMessages.add(String.format("Invalid length of the S{%s}: %d", datas.getStringS(),
                    datas.getNIsLengthOfS()));
        }
    }

    private void validateNumber(int num, String field, List<String> errorMessages) {
        validate(num, field, MIN_NUM, "less", errorMessages);
        validate(num, field, MAX_NUM, "more", errorMessages);
    }

    private void validate(int num, String field, int limit, String comparison, List<String> errorMessages) {
        if (num < MIN_NUM || num > MAX_NUM) {
            errorMessages.add(String.format("%s={%d} is %s than %d", field, num, comparison, limit));
        }
    }
}
package com.bookmap.validator;

public interface Validator<T> {
    void isValid(T value);
}
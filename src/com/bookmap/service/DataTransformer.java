package com.bookmap.service;

@FunctionalInterface
public interface DataTransformer<T, R> {
    R transform(T data);
}
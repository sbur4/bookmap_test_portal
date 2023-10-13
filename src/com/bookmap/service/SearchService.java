package com.bookmap.service;

public interface SearchService<C, M> {
    C findIndexes(M model);
}
package com.bookmap.mapper;

public interface Mapper<M, I, O> {
    void mapDtoToModel(M model, I dto);

    O mapModelToDto(M model);
}
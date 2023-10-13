package com.bookmap.factory;

import com.bookmap.mapper.impl.DatasMapperImpl;

public class MapperFactory {
    private final DatasMapperImpl dataMapper;

    public MapperFactory(DatasMapperImpl dataMapper) {
        this.dataMapper = dataMapper;
    }

    public DatasMapperImpl createDatasMapper() {
        return dataMapper;
    }
}
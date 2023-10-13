package com.bookmap.controller;

import com.bookmap.dto.InputDto;
import com.bookmap.dto.OutputDto;
import com.bookmap.factory.MapperFactory;
import com.bookmap.factory.ValidatorFactory;
import com.bookmap.hanlder.impl.TxtIOServiceImpl;
import com.bookmap.mapper.impl.DatasMapperImpl;
import com.bookmap.model.Datas;
import com.bookmap.service.impl.IndexSearchServiceImpl;
import com.bookmap.validator.impl.InputDataValidatorImpl;

public class Controller {
    public void processRun(Datas datas, ValidatorFactory validatorFactory, TxtIOServiceImpl ioService,
                           MapperFactory mapperFactory, IndexSearchServiceImpl indexSearchService) {
        InputDto inputDto = new InputDto(ioService.readData(datas.getInputPathToFile(),
                validatorFactory.createReadFileValidator()));

        DatasMapperImpl dataMapper = mapperFactory.createDatasMapper();
        dataMapper.mapDtoToModel(datas, inputDto);

        InputDataValidatorImpl inputDataValidator = validatorFactory.createInputDataValidator();
        inputDataValidator.isValid(datas);

        datas.setFoundIndexes(indexSearchService.findIndexes(datas));

        OutputDto outputDto = dataMapper.mapModelToDto(datas);
        ioService.writeData(outputDto, datas.getOutputPathToFile(),
                validatorFactory.createWriteFileValidator());
    }
}
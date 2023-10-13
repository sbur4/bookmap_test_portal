package com.bookmap.mapper.impl;

import com.bookmap.dto.InputDto;
import com.bookmap.dto.OutputDto;
import com.bookmap.mapper.Mapper;
import com.bookmap.model.Datas;
import com.bookmap.model.Query;
import com.bookmap.service.DataTransformer;

import java.util.List;
import java.util.stream.Collectors;

public class DatasMapperImpl implements Mapper<Datas, InputDto, OutputDto> {
    @Override
    public void mapDtoToModel(Datas datas, InputDto inputDto) {
        DataTransformer<String, Integer> intParser = item -> {
            try {
                return Integer.parseInt(item);
            } catch (NumberFormatException | NullPointerException nfe) {
                throw new IllegalArgumentException(String.format("Invalid input: {%s}", item));
            }
        };

        if (inputDto == null || inputDto.getText() == null || inputDto.getText().isEmpty()) {
            return;
        }

        List<String> text = inputDto.getText();

        text.stream().findFirst().ifPresent(firstText -> {
            String[] items = firstText.split(" ");
            if (items.length == 2) {
                datas.setNIsLengthOfS(intParser.transform(items[0]));
                datas.setQIsNumberOfQueries(intParser.transform(items[1]));
            }
        });

        text.stream().skip(1).findFirst().ifPresent(secondText -> datas.setStringS(secondText.trim()));

        List<Query> queryList = text.stream()
                .skip(2)
                .map(str -> str.split(" "))
                .map(arr -> new Query(
                        intParser.transform(arr[0]),
                        intParser.transform(arr[1]),
                        intParser.transform(arr[2])))
                .collect(Collectors.toList());

        datas.setQueryList(queryList);
    }

    @Override
    public OutputDto mapModelToDto(Datas datas) {
        return (datas == null || datas.getFoundIndexes() == null || datas.getFoundIndexes().isEmpty())
                ? null : new OutputDto(datas.getFoundIndexes());
    }
}
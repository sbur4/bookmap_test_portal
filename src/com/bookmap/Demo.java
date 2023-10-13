package com.bookmap;

import com.bookmap.controller.Controller;
import com.bookmap.factory.MapperFactory;
import com.bookmap.factory.ValidatorFactory;
import com.bookmap.hanlder.impl.TxtIOServiceImpl;
import com.bookmap.mapper.impl.DatasMapperImpl;
import com.bookmap.model.Datas;
import com.bookmap.service.impl.IndexSearchServiceImpl;
import com.bookmap.validator.impl.InputDataValidatorImpl;
import com.bookmap.validator.impl.ReadFileValidatorImpl;
import com.bookmap.validator.impl.WriteFileValidatorImpl;

public class Demo {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Current timestamp in milliseconds: " + currentTimeMillis);

        String inputPathToFile = "input.txt";
        String outputPathToFile = "output.txt";
        Datas datas = new Datas(inputPathToFile, outputPathToFile);

        Controller controller = new Controller();
        controller.processRun(datas, initValidators(), initIOService(), initMappers(), initSearchService());

        long endTimeMillis = System.currentTimeMillis();
        System.out.println("Current timestamp in milliseconds: " + (endTimeMillis - currentTimeMillis));
    }

    private static ValidatorFactory initValidators() {
        return new ValidatorFactory(new ReadFileValidatorImpl(), new InputDataValidatorImpl(),
                new WriteFileValidatorImpl());
    }

    private static TxtIOServiceImpl initIOService() {
        return new TxtIOServiceImpl();
    }

    private static MapperFactory initMappers() {
        return new MapperFactory(new DatasMapperImpl());
    }

    private static IndexSearchServiceImpl initSearchService() {
        return new IndexSearchServiceImpl();
    }
}
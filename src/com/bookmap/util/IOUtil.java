package com.bookmap.util;

import com.bookmap.exception.FileIOException;
import com.bookmap.exception.ReadDataException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IOUtil {
    private IOUtil() {
    }

    public static List<String> readDataFromFile(String inputPathToFile) {
        try {
            return Files.readAllLines(Paths.get(inputPathToFile), StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            throw new ReadDataException(String.format("Can't read data from the file: {%s}.", inputPathToFile));
        }
    }

    public static void writeDataToFile(String outputPathToFile, List<Integer> result) {
        String outputData = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));

        try {
            Files.write(Paths.get(outputPathToFile), outputData.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioException) {
            throw new ReadDataException(String.format("Can't write data to the file: {%s}.", outputPathToFile));
        }
    }

    public static void createFile(String outputPathToFile) {
        try {
            Files.createFile(Paths.get(outputPathToFile));
        } catch (IOException ioException) {
            throw new FileIOException(String.format("Can't create the file: {%s}.", outputPathToFile));
        }
    }
}
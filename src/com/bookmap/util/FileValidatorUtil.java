package com.bookmap.util;

import com.bookmap.exception.FileIOException;
import com.bookmap.exception.GenericException;
import com.bookmap.exception.ReadDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileValidatorUtil {
    private FileValidatorUtil() {
    }

    public static void isValidPathToFile(String pathToFile) {
        if (Objects.isNull(pathToFile) || pathToFile.isEmpty()) {
            throw new GenericException(String.format("Incorrect path to the file: {%s}", pathToFile));
        }
    }

    public static void isFileExist(String pathToFile) {
        if (!Files.exists(Paths.get(pathToFile))) {
            throw new FileIOException(String.format("The file does not exist: {%s}", pathToFile));
        }
    }

    public static void isEmptyFile(String pathToFile) {
        long fileSize = getFileSize(Paths.get(pathToFile));

        if (fileSize == 0) {
            throw new FileIOException(String.format("The file is empty: {%s}", pathToFile));
        }
    }

    private static long getFileSize(Path pathToFile) {
        try {
            return Files.size(pathToFile);
        } catch (IOException ioException) {
            throw new ReadDataException(String.format("Error reading file size: {%s}.", pathToFile));
        }
    }
}
package com.bookmap.dto;

import java.util.Collections;
import java.util.List;

public final class OutputDto {
    private final List<Integer> result;

    public OutputDto(List<Integer> result) {
        this.result = Collections.unmodifiableList(result);
    }

    public List<Integer> getResult() {
        return result;
    }
}
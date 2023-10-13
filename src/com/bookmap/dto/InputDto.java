package com.bookmap.dto;

import java.util.Collections;
import java.util.List;

public final class InputDto {
    private final List<String> text;

    public InputDto(List<String> text) {
        this.text = Collections.unmodifiableList(text);
    }

    public List<String> getText() {
        return text;
    }
}
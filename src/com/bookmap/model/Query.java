package com.bookmap.model;

import java.util.StringJoiner;

public class Query {
    private final Integer l;
    private final Integer r;
    private final Integer k;

    public Query(Integer startIndex, Integer endIndex, Integer charPosition) {
        this.l = startIndex;
        this.r = endIndex;
        this.k = charPosition;
    }

    public Integer getL() {
        return l;
    }

    public Integer getR() {
        return r;
    }

    public Integer getK() {
        return k;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Query.class.getSimpleName() + "[", "]")
                .add("startIndex=" + l)
                .add("endIndex=" + r)
                .add("charPosition=" + k)
                .toString();
    }
}
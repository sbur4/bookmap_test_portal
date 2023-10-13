package com.bookmap.model;

import java.util.List;
import java.util.StringJoiner;

public class Datas {
    private final String inputPathToFile;
    private final String outputPathToFile;
    private String stringS;
    private Integer nIsLengthOfS;
    private List<Query> queryList;
    private Integer qIsNumberOfQueries;
    private List<Integer> foundIndexes;

    public Datas(String inputPathToFile, String outputPathToFile) {
        this.inputPathToFile = inputPathToFile;
        this.outputPathToFile = outputPathToFile;
    }

    public String getInputPathToFile() {
        return inputPathToFile;
    }

    public String getOutputPathToFile() {
        return outputPathToFile;
    }

    public String getStringS() {
        return stringS;
    }

    public void setStringS(String stringS) {
        this.stringS = stringS;
    }

    public Integer getNIsLengthOfS() {
        return nIsLengthOfS;
    }

    public void setNIsLengthOfS(Integer nIsLengthOfS) {
        this.nIsLengthOfS = nIsLengthOfS;
    }

    public List<Query> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<Query> queryList) {
        this.queryList = queryList;
    }

    public Integer getQIsNumberOfQueries() {
        return qIsNumberOfQueries;
    }

    public void setQIsNumberOfQueries(Integer qIsNumberOfQueries) {
        this.qIsNumberOfQueries = qIsNumberOfQueries;
    }

    public List<Integer> getFoundIndexes() {
        return foundIndexes;
    }

    public void setFoundIndexes(List<Integer> foundIndexes) {
        this.foundIndexes = foundIndexes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Datas.class.getSimpleName() + "[", "]")
                .add("inputPathToFile=" + inputPathToFile)
                .add("outputPathToFile=" + outputPathToFile)
                .add("s=" + stringS)
                .add("n=" + nIsLengthOfS)
                .add("queries=" + queryList)
                .add("q=" + qIsNumberOfQueries)
                .add("foundIndexes=" + foundIndexes)
                .toString();
    }
}
package com.bookmap.service.impl;

import com.bookmap.model.Datas;
import com.bookmap.service.DataTransformer;
import com.bookmap.service.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IndexSearchServiceImpl implements SearchService<List<Integer>, Datas> {
    @Override
    public List<Integer> findIndexes(Datas datas) {
        DataTransformer<String, List<String>> substringTransformer = substring -> substring.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.toList());

        return datas.getQueryList().stream()
                .map(query -> {
                    String substring = datas.getStringS().substring(query.getL() - 1, query.getR());
                    List<String> items = substringTransformer.transform(substring);

                    int index = query.getK();
                    String k = items.get(index - 1);

                    List<Integer> kPositions = new ArrayList<>();
                    List<Integer> xPositions = new ArrayList<>();

                    fillLists(items, k, kPositions, xPositions);

                    int positionCount = getPositionCount(kPositions, index);

                    if (xPositions.size() < positionCount) {
                        return -1;
                    } else if (index == 1) {
                        return xPositions.get(0);
                    } else {
                        return xPositions.get(positionCount - 1);
                    }
                })
                .collect(Collectors.toList());

    }

    private static int getPositionCount(List<Integer> kPositions, int index) {
        int positionCount = 0;
        for (Integer entry : kPositions) {
            positionCount++;
            if (entry.equals(index)) {
                break;
            }
        }
        return positionCount;
    }

    private static void fillLists(List<String> items, String k, List<Integer> kPositions, List<Integer> xPositions) {
        int count = 1;
        for (String str : items) {
            if (str.equals(k)) {
                kPositions.add(count);
            } else {
                xPositions.add(count);
            }
            count++;
        }
    }
}
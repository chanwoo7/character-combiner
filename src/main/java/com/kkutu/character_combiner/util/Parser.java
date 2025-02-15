package com.kkutu.character_combiner.util;

import java.util.*;
import java.util.regex.*;

public class Parser {
    private static final Pattern PATTERN = Pattern.compile("([ABC])([가-힣])x(\\d+)");

    /**
     * 글자 조각 목록 파싱 -> 등급별 글자-개수 목록 반환
     */
    public static Map<String, Map<String, Integer>> parseData(String data) {
        Map<String, Map<String, Integer>> gradeMap = initializeGradeMap();
        Arrays.stream(data.split(","))
                .map(PATTERN::matcher)
                .filter(Matcher::matches)
                .forEach(matcher -> updateGradeMap(gradeMap, matcher));
        return gradeMap;
    }

    private static Map<String, Map<String, Integer>> initializeGradeMap() {
        Map<String, Map<String, Integer>> gradeMap = new HashMap<>();
        gradeMap.put("A", new HashMap<>());
        gradeMap.put("B", new HashMap<>());
        gradeMap.put("C", new HashMap<>());
        return gradeMap;
    }

    private static void updateGradeMap(Map<String, Map<String, Integer>> gradeMap, Matcher matcher) {
        String grade = matcher.group(1);
        String character = matcher.group(2);
        int count = Integer.parseInt(matcher.group(3));
        gradeMap.get(grade).merge(character, count, Integer::sum);
    }
}

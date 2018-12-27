package com.adventOfCode.ims.identify;

import com.adventOfCode.ims.file.ReadFile;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PatternSearch {

    public static void main(String[] args) {
        try {
            PatternSearch patternSearch = new PatternSearch();

            URL uri = patternSearch.getClass().getClassLoader().getSystemClassLoader().getResource("ids.txt");
            Stream<String> lines = ReadFile.readAllLinesInFile(uri.toURI());
            patternSearch.patternSearch(lines);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void patternSearch(Stream<String> lines) {

        Map<String, Integer> resultMap = new HashMap<>();
        lines.forEach(s -> {
            searchRepeatedLetters(s, resultMap);
        });
        System.out.println("two: " + resultMap.get("two"));
        System.out.println("three: " + resultMap.get("three"));
    }


    private void searchRepeatedLetters(String line, Map<String, Integer> resultMap) {
        Map<String, Integer> charsMap = new HashMap<>();
        line.chars().forEach(ch -> {
            if(charsMap.get(""+ch) != null) {
                charsMap.put(""+ch, charsMap.get(""+ch) + 1);
            } else {
                charsMap.put(""+ch, 1);
            }
        });
        for (String s : charsMap.keySet()) {

            if(charsMap.get(s) == 2) {
                if(resultMap.get("two") == null)
                    resultMap.put("two", 1);
                else resultMap.put("two", resultMap.get("two") + 1);

            }
            if(charsMap.get(s) == 3) {
                if(resultMap.get("three") == null)
                    resultMap.put("three", 1);
                else resultMap.put("three", resultMap.get("three") + 1);
            }
        }

    }
}

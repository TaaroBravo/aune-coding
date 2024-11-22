package com.lautarobravo.aune_interview;

import java.util.*;

public class AppReader {


    public Map<String, Integer> evaluate(String entry) {

        var textWithoutCharacters = entry
                .replaceAll("\\.","")
                .replaceAll(",","")
                .replace("#", "")
                .replace("\n", "");

        var words = Arrays.stream(textWithoutCharacters.toLowerCase().split(" "))
                .filter(w -> !Arrays.asList(commonArticles()).contains(w))
                .toList();

        Map<String, Integer> totalWords = new HashMap<>();

        for (var word : words){
            if(totalWords.containsKey(word))
                totalWords.put(word, totalWords.get(word) + 1);
            else
                totalWords.put(word, 1);
        }

        return totalWords;
    }

    public String[] commonArticles(){
        return new String []{
                "the",
                "and",
                "in",
                "of",
                "to",
                "a",
                "is",
                "an"
        };
    }
}

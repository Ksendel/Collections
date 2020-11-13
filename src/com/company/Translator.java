package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Translator {
    Dictionary dictionaryForward;
    Dictionary dictionaryBackward;

    public Translator(Dictionary dictionary) {
        this.dictionaryForward = dictionary;
        this.dictionaryBackward = dictionary.reverse();
    }

    public String forwardTranslate(String words) {
        return Arrays.stream(words.split(" "))
                .map(x -> dictionaryForward.translate(x))
                .collect(Collectors.joining(" "));
    }

    public String backwardTranslate(String words) {
        return Arrays.stream(words.split(" "))
                .map(x -> dictionaryBackward.translate(x))
                .collect(Collectors.joining(" "));
    }
}

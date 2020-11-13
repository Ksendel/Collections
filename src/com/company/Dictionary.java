package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;

    public Map<String, String> dictionary;

    public Dictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(String word, String translation) {
        dictionary.put(word.toLowerCase(), translation.toLowerCase());
    }

    public String translate(String word) {
        return dictionary.getOrDefault(word, word);
    }

    public void saveTo(String path) throws IOException {
        String eol = System.getProperty("line.separator");
        try ( PrintWriter writer = new PrintWriter(new File(path)) ) {
           for (Map.Entry<String, String> entry : dictionary.entrySet()){
               writer.append(entry.getKey())
                       .append(',')
                       .append(entry.getValue())
                       .append(eol);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Dictionary loadFrom(String pathLoad) throws FileNotFoundException {
        Map<String, String> dictionary = new HashMap<>();
        Stream<String> reader = new BufferedReader(new FileReader(pathLoad)).lines();

        reader.forEach(x -> {
            String[] words =
                    x.split(",");
            if (words.length == 2)
                dictionary.put(words[0], words[1]);
        });

        return new Dictionary(dictionary);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public Dictionary reverse() {
        Map<String, String> reversed = new HashMap<>();
        dictionary.forEach((k, v) -> reversed.put(v, k));
        return new Dictionary(reversed);
    }
}

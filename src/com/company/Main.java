package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pathLoad = "C:/1КОПЕЫ/ІК-83/5 семестр/Java/Labs/Lab6/src/resources/dictionary.txt";

        try {
            Dictionary dictionaryEng = Dictionary.loadFrom(pathLoad);

            Translator translator = new Translator(dictionaryEng);
            Menu menu = new Menu();
            int translatorMode;

            while (true) {
                menu.show();
                translatorMode = scanner.nextInt();
                switch (translatorMode) {
                    case 1 -> {
                        System.out.println("Enter english word:");
                        String eng = new Scanner(System.in).nextLine();
                        System.out.println("Enter translate:");
                        String ukr = new Scanner(System.in).nextLine();
                        dictionaryEng.addWord(eng, ukr);
                    }
                    case 2 -> {
                        System.out.println("Enter english sentence:");
                        String englishSentence = new Scanner(System.in).nextLine();
                        System.out.println(translator.forwardTranslate(englishSentence.toLowerCase()));
                    }
                    case 3 -> {
                        System.out.println("Enter Ukrainian sentence:");
                        String ukrainianSentence = new Scanner(System.in).nextLine();
                        System.out.println(translator.backwardTranslate(ukrainianSentence.toLowerCase()));
                    }
                    case 4 -> {
                        System.out.println("Enter path to save dictionary(EXAMPLE d:\\java\\dictionary.txt):");
                        String path = new Scanner(System.in).nextLine();
                        dictionaryEng.saveTo(path);
                    }
                    case 0 -> {
                        System.exit(1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

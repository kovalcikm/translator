package com.kovalcik.translator;

import com.kovalcik.translator.word.ConsonantFirst;
import com.kovalcik.translator.word.NoChange;
import com.kovalcik.translator.word.VowelFirst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Translator {

    private static final char HYPHEN = '-';
    private static final String WHITESPACE =  " +";

    private List<Transformation> transformations =
            Arrays.asList( new NoChange(), new VowelFirst(), new ConsonantFirst()); //NoChange transformation needs to be first

    /**
     * Reads file and translates the content to "pig-latin" to console output
     *
     * @param file containing the text
     * @throws IOException if it is unable to read the file
     */
    void readAndTranslate(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(WHITESPACE);

            for (String w : words) {
                if (w.length() == 0) continue;

                String[] toTranslateWords = w.split(String.valueOf(HYPHEN));

                for (int i = 0; i < toTranslateWords.length; i++) {
                    if (i > 0) System.out.print(HYPHEN);
                    if (!toTranslateWords[i].isEmpty()){
                        System.out.print(translateWord(toTranslateWords[i]));
                    }
                }
                if (w.charAt(w.length() - 1) == HYPHEN) System.out.print(HYPHEN);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private String translateWord(String word) {
        for (Transformation t : transformations) {
            if (t.apply(word)) return t.execute(word);
        }
        return word;
    }
}

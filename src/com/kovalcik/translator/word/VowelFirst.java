package com.kovalcik.translator.word;

import com.kovalcik.translator.CharacterChecker;
import com.kovalcik.translator.Transformation;


public class VowelFirst implements Transformation {

    private static final String VOWEL_SUFFIX = "way";

    @Override
    public boolean apply(String word) {
        return CharacterChecker.isVowel(Character.toUpperCase(word.charAt(0)));
    }

    /**
     * Word that starts with a vowel has the letters “way” added to the end.
     *
     * @param word
     * @return translated word
     */
    @Override
    public String execute(String word) {

        StringBuilder original = new StringBuilder(word);
        StringBuilder modified = new StringBuilder(original);

        modified.append(VOWEL_SUFFIX);
        for (int i = original.length() - 1; i >= 0; i--)
            if (CharacterChecker.isPunctuation(original.charAt(i))) { //same relative place from the end of the word
                int indexFromEnd = original.length() - 1 - i;
                modified.deleteCharAt(i);
                modified.insert(modified.length() - indexFromEnd, original.charAt(i));
            }
        return modified.toString();
    }
}

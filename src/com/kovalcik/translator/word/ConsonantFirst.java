package com.kovalcik.translator.word;

import com.kovalcik.translator.CharacterChecker;
import com.kovalcik.translator.Transformation;


public class ConsonantFirst implements Transformation {

    private static final String CONSONANT_SUFFIX = "ay";

    @Override
    public boolean apply(String word) {
        return CharacterChecker.isConsonant(Character.toUpperCase(word.charAt(0)));
    }

    /**
     * Word that start with a consonant has its first letter moved to the end of the word and the letters “ay” added to the end.
     * @param word
     * @return translated word
     */
    @Override
    public String execute(String word) {
        StringBuilder original = new StringBuilder(word);
        StringBuilder modified = new StringBuilder(original);

        char first = original.charAt(0);
        modified.deleteCharAt(0);
        modified.append(Character.toLowerCase(first));
        modified.append(CONSONANT_SUFFIX);

        for (int i = original.length() - 1; i >= 0; i--) {
            //consolidate capitalization
            if (CharacterChecker.isVowelOrConsonant(original.charAt(i))) {
                if (Character.isLowerCase(original.charAt(i))) {
                    modified.setCharAt(i, Character.toLowerCase(modified.charAt(i)));
                } else {
                    modified.setCharAt(i, Character.toUpperCase(modified.charAt(i)));
                }
            }

            //consolidate punctuation (same relative place from the end of the word)
            if (CharacterChecker.isPunctuation(original.charAt(i))) {
                int indexFromEnd = original.length() - 1 - i;
                modified.deleteCharAt(i - 1);
                modified.insert(modified.length() - indexFromEnd, original.charAt(i));
            }
        }

        return modified.toString();
    }
}

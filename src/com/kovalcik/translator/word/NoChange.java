package com.kovalcik.translator.word;

import com.kovalcik.translator.Transformation;


public class NoChange implements Transformation {

    private static final String NO_CHANGE_SUFFIX = "way";

    @Override
    public boolean apply(String word) {
        return word.endsWith(NO_CHANGE_SUFFIX);
    }

    /**
     * Word that ends in “way” is not modified.
     *
     * @param word
     * @return not modified word
     */
    @Override
    public String execute(String word) {
        return word;
    }
}

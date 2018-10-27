package com.kovalcik.translator;

/**
 * Interface for word transformation.
 */
public interface Transformation {

    boolean apply(String word);

    String execute(String word);

}


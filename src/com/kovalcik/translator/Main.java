package com.kovalcik.translator;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("One parameter expected (path to input file).");
            return;
        }
        File file = new File(args[0]);
        if (!file.exists()){
            System.out.printf("File does not exist: %s", args[0]);
            return;
        }

        new Translator().readAndTranslate(file);
    }
}

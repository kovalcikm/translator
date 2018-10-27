package com.kovalcik.translator;

/**
 * Class for checking character. Using constans for better performance
 */
public class CharacterChecker {

    private static int[] vowels = new int[256];
    private static int[] consonants = new int[256];
    private static int[] punctuation = new int[256];


    static {
        vowels['A'] = vowels['E'] = vowels['I'] = vowels['O'] = vowels['U'] = vowels['A'] = vowels['E'] = vowels['I'] =
        vowels['U'] = vowels['O'] = 1;

        consonants['B'] = consonants['C'] = consonants['D'] = consonants['F'] = consonants['G'] = consonants['H'] =
        consonants['J'] = consonants['K'] = consonants['L'] = consonants['M'] = consonants['N'] = consonants['P'] =
        consonants['Q'] = consonants['R'] = consonants['S'] = consonants['T'] = consonants['V'] = consonants['X'] =
        consonants['Z'] = consonants['W'] = consonants['Y'] = 1;

        punctuation['.'] = punctuation[','] = punctuation['!'] = punctuation['?'] = punctuation[':'] =
        punctuation[';'] = punctuation['"'] = punctuation['\''] = punctuation['('] = punctuation[')'] =
        punctuation['{'] = punctuation['}'] = punctuation['_'] = 1;

    }


    public static boolean isVowel(char character){
        return vowels[Character.toUpperCase(character)] == 1;
    }

    public static boolean isConsonant(char character){
        return consonants[Character.toUpperCase(character)] == 1;
    }

    public static boolean isPunctuation(char character){
        return punctuation[character] == 1;
    }

    public static boolean isVowelOrConsonant(char character){
        return isVowel(character) || isConsonant(character);
    }

}

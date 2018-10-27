package com.kovalcik.translator.word;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsonantFirstTest {

    @Test
    public void testOneCharacter() {
        ConsonantFirst consonantFirst = new ConsonantFirst();

        String translated = consonantFirst.execute("H");
        assertEquals("Hay", translated);
    }

    @Test
    public void testAllSmall() {
        ConsonantFirst consonantFirst = new ConsonantFirst();

        String translated = consonantFirst.execute("hello");
        assertEquals("ellohay", translated);
    }

    @Test
    public void testCapitalization() {
        ConsonantFirst consonantFirst = new ConsonantFirst();

        String translated = consonantFirst.execute("HeLlO");
        assertEquals("ElLoHay", translated);
    }

    @Test
    public void testPunctuation() {
        ConsonantFirst consonantFirst = new ConsonantFirst();

        String translated = consonantFirst.execute("c.ant");
        assertEquals("ant.cay", translated);

        translated = consonantFirst.execute("h.el_lo!");
        assertEquals("ell.oh_ay!", translated);

        translated = consonantFirst.execute("can't");
        assertEquals("antca'y", translated);
    }

    @Test
    public void testCapitalizationWithPunctuation() {
        ConsonantFirst consonantFirst = new ConsonantFirst();

        String translated = consonantFirst.execute("H_");
        assertEquals("Hay_", translated);
    }

    /*
     * More tests....
     */
}